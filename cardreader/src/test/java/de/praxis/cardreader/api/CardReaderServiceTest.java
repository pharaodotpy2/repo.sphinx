package de.praxis.cardreader.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.praxis.cardreader.spi.CardReaderDriver;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class CardReaderServiceTest {
    @Test
    void shouldUseManualFallback() {
        CardReaderService service = new CardReaderService(List.of(new NoopDriver()));
        CardReadResult result = service.manualFallback("A123", "Max", "Mustermann");
        assertEquals("A123", result.insuranceNumber());
    }

    static class NoopDriver implements CardReaderDriver {
        public String terminalName() { return "noop"; }
        public boolean isConnected() { return false; }
        public Optional<CardReadResult> readCard() { return Optional.empty(); }
    }
}
