package de.praxis.core.ports;

/**
 * Audit trail abstraction for DSGVO/BSI-oriented tracking.
 */
public interface AuditPort {
    void logAccess(String username, String action, String target, String details);
}
