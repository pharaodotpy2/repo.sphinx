package de.praxis.frontend.controller;

import de.praxis.frontend.model.PatientViewModel;
import de.praxis.frontend.service.BackendClient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<String> patientList;

    @FXML
    private Label statusLabel;

    private final BackendClient client = new BackendClient();

    @FXML
    public void initialize() {
        statusLabel.setText("Lade Patientendaten...");
        client.fetchPatients().thenAccept(this::renderPatients);
    }

    private void renderPatients(java.util.List<PatientViewModel> patients) {
        Platform.runLater(() -> {
            patientList.setItems(FXCollections.observableArrayList(
                    patients.stream().map(p -> p.id() + " - " + p.firstName() + " " + p.lastName()).toList()));
            statusLabel.setText("Geladen: " + patients.size() + " Patienten");
        });
    }
}
