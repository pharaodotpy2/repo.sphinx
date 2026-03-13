package de.praxis.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Domänenmodell für Patientenstammdaten. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private UUID id;
    private String versichertennummer;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String adresse;
    private String plz;
    private String ort;
    private Krankenkasse krankenkasse;
    private String kassenname;
    private List<String> allergien;
    private List<String> dauerdiagnosen;
    private List<Medikament> medikamente;
    private LocalDateTime erstelltAm;
    private LocalDateTime geaendertAm;
    private boolean aktiv;
}
