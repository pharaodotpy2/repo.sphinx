package de.praxis.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** JavaFX entry point for desktop client. */
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/app.fxml")), 1366, 820);
        scene.getStylesheets().add(getClass().getResource("/css/base.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/css/layout.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/css/components.css").toExternalForm());
        stage.setTitle("Praxisverwaltungssystem — Sterile Agility");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}
