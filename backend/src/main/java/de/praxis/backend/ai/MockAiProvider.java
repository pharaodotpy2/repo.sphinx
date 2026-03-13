package de.praxis.backend.ai;

import de.praxis.core.model.IcdVorschlag;
import de.praxis.core.model.Patient;
import de.praxis.core.model.Termin;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Component;

/** Offline mock provider for development/testing without API keys. */
@Component
public class MockAiProvider implements AiProvider {
    @Override
    public String getProviderName() { return "mock"; }

    @Override
    public CompletableFuture<List<IcdVorschlag>> icdVorschlaege(String symptombeschreibung) {
        return CompletableFuture.completedFuture(List.of(
                IcdVorschlag.builder().code("J06.9").bezeichnung("Akute Infektion der oberen Atemwege").confidence(0.73).build(),
                IcdVorschlag.builder().code("R05").bezeichnung("Husten").confidence(0.62).build()));
    }

    @Override
    public CompletableFuture<String> arztbriefEntwurf(Patient patient, String anlass) {
        return CompletableFuture.completedFuture("Arztbrief Entwurf für " + patient.getVorname() + " " + patient.getNachname() + ": " + anlass);
    }

    @Override
    public CompletableFuture<String> anamneseSammenfassung(String diktat) {
        return CompletableFuture.completedFuture("Zusammenfassung: " + diktat);
    }

    @Override
    public CompletableFuture<Double> keineErscheinungsWahrscheinlichkeit(Patient patient, Termin termin) {
        return CompletableFuture.completedFuture(0.15d);
    }
}
