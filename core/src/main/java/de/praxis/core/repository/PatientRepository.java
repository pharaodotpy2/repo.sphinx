package de.praxis.core.repository;

import de.praxis.core.model.Patient;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** Repository-Abstraktion für Patienten. */
public interface PatientRepository {
    Patient save(Patient patient);
    Optional<Patient> findById(UUID id);
    List<Patient> findAll();
    List<Patient> search(String query);
}
