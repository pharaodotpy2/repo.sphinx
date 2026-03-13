package de.praxis.cardreader.api;

import de.praxis.cardreader.legacy.KvkFallbackReader;
import de.praxis.cardreader.spi.CardReaderDriver;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/** Service facade around card terminals and fallback mode. */
@Service
public class CardReaderService {
    private final List<CardReaderDriver> drivers;
    private final KvkFallbackReader fallbackReader = new KvkFallbackReader();

    public CardReaderService(List<CardReaderDriver> drivers) {
        this.drivers = drivers;
    }

    public Optional<CardReadResult> readEgk() {
        return drivers.stream().filter(CardReaderDriver::isConnected).findFirst().flatMap(CardReaderDriver::readCard);
    }

    public CardReadResult manualFallback(String insuranceNumber, String firstName, String lastName) {
        return fallbackReader.fromManualEntry(insuranceNumber, firstName, lastName);
    }
}
