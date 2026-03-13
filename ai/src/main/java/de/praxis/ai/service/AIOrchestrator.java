package de.praxis.ai.service;

import de.praxis.ai.api.AIUseCase;
import de.praxis.ai.config.AIProperties;
import de.praxis.core.ports.AIProvider;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Routes AI requests to configured providers with per-feature switches.
 */
@Service
public class AIOrchestrator {
    private final AIProperties properties;
    private final List<AIProvider> providers;

    public AIOrchestrator(AIProperties properties, List<AIProvider> providers) {
        this.properties = properties;
        this.providers = providers;
    }

    public String run(AIUseCase useCase, String prompt) {
        if (!properties.isEnabled(useCase)) {
            return "AI feature disabled: " + useCase;
        }
        var provider = providers.stream()
                .filter(p -> p.name().equalsIgnoreCase(properties.getProvider()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No AI provider configured"));
        return provider.complete("[" + useCase + "] " + prompt);
    }
}
