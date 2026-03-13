package de.praxis.backend.repository.impl;

import de.praxis.backend.entity.TerminRecord;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringTerminRecordRepository extends JpaRepository<TerminRecord, UUID> {
    List<TerminRecord> findByBeginnBetween(LocalDateTime start, LocalDateTime end);
    List<TerminRecord> findByPatientId(UUID patientId);
}
