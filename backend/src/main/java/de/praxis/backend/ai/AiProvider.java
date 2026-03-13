package de.praxis.backend.ai;

import de.praxis.core.model.IcdVorschlag;
import de.praxis.core.model.Patient;
import de.praxis.core.model.Termin;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/** Asynchronous AI provider interface for all KI features. */
public interface AiProvider {
    String getProviderName();
    CompletableFuture<List<IcdVorschlag>> icdVorschlaege(String symptombeschreibung);
    CompletableFuture<String> arztbriefEntwurf(Patient patient, String anlass);
    CompletableFuture<String> anamneseSammenfassung(String diktat);
    CompletableFuture<Double> keineErscheinungsWahrscheinlichkeit(Patient patient, Termin termin);
}
