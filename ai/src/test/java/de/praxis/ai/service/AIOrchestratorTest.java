package de.praxis.ai.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.praxis.ai.api.AIUseCase;
import de.praxis.ai.config.AIProperties;
import de.praxis.ai.provider.OllamaProvider;
import java.util.List;
import org.junit.jupiter.api.Test;

class AIOrchestratorTest {

    @Test
    void shouldRunWithConfiguredProvider() {
        AIProperties p = new AIProperties();
        p.getEnabled().put(AIUseCase.ICD10_SUGGESTION, true);
        AIOrchestrator orchestrator = new AIOrchestrator(p, List.of(new OllamaProvider()));
        String response = orchestrator.run(AIUseCase.ICD10_SUGGESTION, "Husten");
        assertTrue(response.contains("OLLAMA"));
    }
}
