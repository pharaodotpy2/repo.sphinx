package de.praxis.core.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Daten von der elektronischen Gesundheitskarte. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EgkDaten {
    private String versichertennummer;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String kassenname;
    private Krankenkasse krankenkasse;
}
