package de.praxis.core.ports;

/**
 * Pluggable AI provider abstraction (OpenAI, Anthropic, Ollama).
 */
public interface AIProvider {
    String name();

    String complete(String prompt);
}
