package de.praxis.backend.infrastructure.persistence;

import de.praxis.backend.domain.AuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringAuditJpaRepository extends JpaRepository<AuditLogEntity, Long> {
}
