package de.praxis.core.service;

import de.praxis.core.model.Patient;
import java.util.List;
import java.util.UUID;

/** Servicevertrag für Patientenverwaltung. */
public interface PatientService {
    Patient anlegen(Patient patient);
    Patient aktualisieren(UUID id, Patient patient);
    List<Patient> suchen(String query);
    List<Patient> alle();
}
