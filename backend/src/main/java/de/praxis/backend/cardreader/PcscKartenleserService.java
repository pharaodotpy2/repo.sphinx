package de.praxis.backend.cardreader;

import de.praxis.core.model.EgkDaten;
import de.praxis.core.model.Krankenkasse;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

/** PCSC card reader placeholder; can be replaced with terminal-specific implementation. */
@Service
public class PcscKartenleserService implements KartenleserService {
    @Override
    public boolean isVerbunden() { return false; }

    @Override
    public Optional<EgkDaten> karteEinlesen() {
        return Optional.of(EgkDaten.builder()
                .versichertennummer("DEMO-0001")
                .vorname("Erika")
                .nachname("Muster")
                .geburtsdatum(LocalDate.of(1982, 2, 14))
                .kassenname("AOK")
                .krankenkasse(Krankenkasse.GKV)
                .build());
    }

    @Override
    public void onKarteEingesteckt(Consumer<EgkDaten> callback) { karteEinlesen().ifPresent(callback); }

    @Override
    public void onKarteEntfernt(Runnable callback) { callback.run(); }
}
