package de.praxis.backend.cardreader;

import de.praxis.core.model.EgkDaten;
import java.util.Optional;
import java.util.function.Consumer;

/** Service contract for eGK card reader integration. */
public interface KartenleserService {
    boolean isVerbunden();
    Optional<EgkDaten> karteEinlesen();
    void onKarteEingesteckt(Consumer<EgkDaten> callback);
    void onKarteEntfernt(Runnable callback);
}
