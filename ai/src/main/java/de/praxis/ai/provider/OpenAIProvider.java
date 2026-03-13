package de.praxis.ai.provider;

import de.praxis.core.ports.AIProvider;
import org.springframework.stereotype.Component;

@Component
public class OpenAIProvider implements AIProvider {
    @Override
    public String name() { return "openai"; }

    @Override
    public String complete(String prompt) {
        return "[OPENAI-STUB] " + prompt;
    }
}
