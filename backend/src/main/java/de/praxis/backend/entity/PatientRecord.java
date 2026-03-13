package de.praxis.backend.entity;

import de.praxis.core.model.Krankenkasse;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patienten")
@Getter
@Setter
public class PatientRecord {
    @Id
    private UUID id;
    @Column(unique = true, nullable = false)
    private String versichertennummer;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String adresse;
    private String plz;
    private String ort;
    @Enumerated(EnumType.STRING)
    private Krankenkasse krankenkasse;
    private String kassenname;
    private String allergien;
    private String dauerdiagnosen;
    private String medikamente;
    private LocalDateTime erstelltAm;
    private LocalDateTime geaendertAm;
    private boolean aktiv;
}
