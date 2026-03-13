package de.praxis.cardreader.spi;

import de.praxis.cardreader.api.CardReadResult;
import java.util.Optional;

/** SPI abstraction for hot-pluggable card reader drivers. */
public interface CardReaderDriver {
    String terminalName();

    boolean isConnected();

    Optional<CardReadResult> readCard();
}
