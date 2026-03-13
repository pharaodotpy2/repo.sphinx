package de.praxis.backend.repository.impl;

import de.praxis.backend.entity.PatientRecord;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringPatientRecordRepository extends JpaRepository<PatientRecord, UUID> {
    List<PatientRecord> findByVornameContainingIgnoreCaseOrNachnameContainingIgnoreCaseOrVersichertennummerContainingIgnoreCase(
            String vorname, String nachname, String versichertennummer);
}
