package de.praxis.ai.config;

import java.util.EnumMap;
import java.util.Map;
import de.praxis.ai.api.AIUseCase;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.ai")
public class AIProperties {
    private String provider = "ollama";
    private final Map<AIUseCase, Boolean> enabled = new EnumMap<>(AIUseCase.class);

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }
    public Map<AIUseCase, Boolean> getEnabled() { return enabled; }
    public boolean isEnabled(AIUseCase useCase) { return enabled.getOrDefault(useCase, Boolean.TRUE); }
}
