package de.praxis.cardreader.api;

import de.praxis.core.model.EgkDaten;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

/** Default implementation delegating to legacy/card terminal adapters. */
@Service
public class KartenleserServiceImpl implements KartenleserService {
    private final CardReaderService delegate;

    public KartenleserServiceImpl(CardReaderService delegate) { this.delegate = delegate; }

    @Override
    public boolean isVerbunden() { return delegate.readEgk().isPresent(); }

    @Override
    public Optional<EgkDaten> karteEinlesen() {
        return delegate.readEgk().map(r -> EgkDaten.builder()
                .versichertennummer(r.insuranceNumber())
                .vorname(r.firstName())
                .nachname(r.lastName())
                .geburtsdatum(r.dateOfBirth())
                .kassenname(r.insuranceProvider())
                .build());
    }

    @Override
    public void onKarteEingesteckt(Consumer<EgkDaten> callback) { karteEinlesen().ifPresent(callback); }

    @Override
    public void onKarteEntfernt(Runnable callback) { callback.run(); }
}
