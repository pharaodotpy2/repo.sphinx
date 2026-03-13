package de.praxis.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** KI-Vorschlag für ICD-10 Kodierung. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IcdVorschlag {
    private String code;
    private String bezeichnung;
    private double confidence;
}
