package de.praxis.cardreader.pcsc;

import de.praxis.cardreader.api.CardReadResult;
import de.praxis.cardreader.spi.CardReaderDriver;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Placeholder PCSC implementation via javax.smartcardio integration point.
 */
@Component
public class PcscCardReaderDriver implements CardReaderDriver {

    @Override
    public String terminalName() {
        return "PCSC-Terminal";
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public Optional<CardReadResult> readCard() {
        return Optional.empty();
    }
}
