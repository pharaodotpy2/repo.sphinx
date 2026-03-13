package de.praxis.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Domänenmodell für Abrechnung. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rechnung {
    private UUID id;
    private UUID patientId;
    private LocalDate rechnungsdatum;
    private List<RechnungsPosition> positionen;
    private BigDecimal gesamtbetrag;
    private RechnungsStatus status;
    private String zugferdXml;
}
