package de.praxis.backend.dto;

import de.praxis.core.model.Krankenkasse;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record PatientDto(
        UUID id,
        String versichertennummer,
        String vorname,
        String nachname,
        LocalDate geburtsdatum,
        String adresse,
        String plz,
        String ort,
        Krankenkasse krankenkasse,
        String kassenname,
        List<String> allergien,
        List<String> dauerdiagnosen,
        boolean aktiv) {}
