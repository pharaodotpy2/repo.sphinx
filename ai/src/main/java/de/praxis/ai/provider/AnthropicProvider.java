package de.praxis.ai.provider;

import de.praxis.core.ports.AIProvider;
import org.springframework.stereotype.Component;

@Component
public class AnthropicProvider implements AIProvider {
    @Override
    public String name() { return "anthropic"; }

    @Override
    public String complete(String prompt) {
        return "[ANTHROPIC-STUB] " + prompt;
    }
}
