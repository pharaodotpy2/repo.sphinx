package de.praxis.cardreader.legacy;

import de.praxis.cardreader.api.CardReadResult;
import java.time.LocalDate;

/** Legacy KVK fallback mapper. */
public class KvkFallbackReader {
    public CardReadResult fromManualEntry(String insuranceNumber, String firstName, String lastName) {
        return new CardReadResult(insuranceNumber, firstName, lastName, LocalDate.of(1980, 1, 1), "UNBEKANNT", true, "KVK fallback");
    }
}
