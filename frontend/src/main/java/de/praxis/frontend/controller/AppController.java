package de.praxis.frontend.controller;

import java.time.LocalTime;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** Main shell controller for dashboard statistics and status. */
public class AppController {
    @FXML private Label readerStatus;
    @FXML private Label kpiTermine;
    @FXML private Label kpiWartend;
    @FXML private Label kpiRechnungen;
    @FXML private Label kpiNachrichten;

    @FXML
    public void initialize() {
        readerStatus.setText("Kartenleser: Offline");
        kpiTermine.setText("Heutige Termine: 24");
        kpiWartend.setText("Wartende Patienten: 6");
        kpiRechnungen.setText("Offene Rechnungen: 17");
        kpiNachrichten.setText("Neue Nachrichten: 3");
    }

    @FXML
    void onGlobalSearch() {
        readerStatus.setText("Suche gestartet um " + LocalTime.now().withNano(0));
    }
}
