package de.praxis.backend.infrastructure.audit;

import de.praxis.backend.domain.AuditLogEntity;
import de.praxis.backend.infrastructure.persistence.SpringAuditJpaRepository;
import de.praxis.core.ports.AuditPort;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class AuditTrailAdapter implements AuditPort {
    private final SpringAuditJpaRepository repository;

    public AuditTrailAdapter(SpringAuditJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logAccess(String username, String action, String target, String details) {
        AuditLogEntity entity = new AuditLogEntity();
        entity.setCreatedAt(Instant.now());
        entity.setUsername(username);
        entity.setAction(action);
        entity.setTarget(target);
        entity.setDetails(details);
        repository.save(entity);
    }
}
