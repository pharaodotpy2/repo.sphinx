package de.praxis.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Medikamentenmodell mit Dosierungstext. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medikament {
    private String name;
    private String wirkstoff;
    private String dosierung;
}
