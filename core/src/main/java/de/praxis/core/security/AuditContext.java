package de.praxis.core.security;

/**
 * Provides actor context for auditing.
 */
public interface AuditContext {
    String currentUsername();
}
