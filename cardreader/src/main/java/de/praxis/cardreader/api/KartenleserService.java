package de.praxis.cardreader.api;

import de.praxis.core.model.EgkDaten;
import java.util.Optional;
import java.util.function.Consumer;

/** eGK reader abstraction for supported terminals and fallback behavior. */
public interface KartenleserService {
    boolean isVerbunden();
    Optional<EgkDaten> karteEinlesen();
    void onKarteEingesteckt(Consumer<EgkDaten> callback);
    void onKarteEntfernt(Runnable callback);
}
