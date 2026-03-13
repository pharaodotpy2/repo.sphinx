package de.praxis.backend.application;

import de.praxis.ai.api.AIUseCase;
import de.praxis.ai.service.AIOrchestrator;
import de.praxis.core.domain.Patient;
import de.praxis.core.ports.AuditPort;
import de.praxis.core.ports.PatientRepositoryPort;
import de.praxis.core.security.AuditContext;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Application service for patient management and AI-assisted duplicate hints.
 */
@Service
public class PatientService {
    private final PatientRepositoryPort repository;
    private final AuditPort auditPort;
    private final AuditContext auditContext;
    private final AIOrchestrator aiOrchestrator;

    public PatientService(PatientRepositoryPort repository, AuditPort auditPort, AuditContext auditContext, AIOrchestrator aiOrchestrator) {
        this.repository = repository;
        this.auditPort = auditPort;
        this.auditContext = auditContext;
        this.aiOrchestrator = aiOrchestrator;
    }

    public Patient create(Patient patient) {
        Patient saved = repository.save(patient);
        auditPort.logAccess(auditContext.currentUsername(), "CREATE", "PATIENT:" + saved.getId(), "created patient");
        return saved;
    }

    public Patient update(Long id, Patient patient) {
        Patient updated = repository.save(patient.toBuilder().id(id).build());
        auditPort.logAccess(auditContext.currentUsername(), "UPDATE", "PATIENT:" + id, "updated patient");
        return updated;
    }

    public List<Patient> all() {
        auditPort.logAccess(auditContext.currentUsername(), "READ", "PATIENT:*", "list all");
        return repository.findAll();
    }

    public List<Patient> search(String query) {
        auditPort.logAccess(auditContext.currentUsername(), "READ", "PATIENT:SEARCH", query);
        return repository.search(query);
    }

    public String duplicateHint(String query) {
        return aiOrchestrator.run(AIUseCase.SEMANTIC_SEARCH, "Duplicate check for: " + query);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        auditPort.logAccess(auditContext.currentUsername(), "DELETE", "PATIENT:" + id, "deleted");
    }
}
