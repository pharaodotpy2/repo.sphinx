package de.praxis.core.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Einzelposition einer Rechnung (GOÄ/EBM). */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RechnungsPosition {
    private String ziffer;
    private String bezeichnung;
    private BigDecimal betrag;
}
