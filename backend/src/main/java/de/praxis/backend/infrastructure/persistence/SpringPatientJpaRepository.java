package de.praxis.backend.infrastructure.persistence;

import de.praxis.backend.domain.PatientEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringPatientJpaRepository extends JpaRepository<PatientEntity, Long> {
    List<PatientEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrInsuranceNumberContainingIgnoreCase(
            String firstName, String lastName, String insuranceNumber);
}
