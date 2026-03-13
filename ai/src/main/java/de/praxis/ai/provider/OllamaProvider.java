package de.praxis.ai.provider;

import de.praxis.core.ports.AIProvider;
import org.springframework.stereotype.Component;

@Component
public class OllamaProvider implements AIProvider {
    @Override
    public String name() { return "ollama"; }

    @Override
    public String complete(String prompt) {
        return "[OLLAMA-STUB] " + prompt;
    }
}
