package de.praxis.frontend.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** JavaFX ViewModel for patient table rows. */
public class PatientViewModel {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty versichertennummer = new SimpleStringProperty();

    public PatientViewModel(String name, String versichertennummer) {
        this.name.set(name);
        this.versichertennummer.set(versichertennummer);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty versichertennummerProperty() { return versichertennummer; }
}
