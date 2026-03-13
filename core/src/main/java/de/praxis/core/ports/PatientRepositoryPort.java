package de.praxis.core.ports;

import de.praxis.core.domain.Patient;
import java.util.List;
import java.util.Optional;

/**
 * Domain-driven persistence port for patient data.
 */
public interface PatientRepositoryPort {
    Patient save(Patient patient);

    Optional<Patient> findById(Long id);

    List<Patient> findAll();

    List<Patient> search(String query);

    void deleteById(Long id);
}
