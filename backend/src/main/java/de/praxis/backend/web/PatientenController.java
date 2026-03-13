package de.praxis.backend.web;

import de.praxis.backend.dto.PatientDto;
import de.praxis.backend.service.impl.PatientServiceImpl;
import de.praxis.core.model.Patient;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

/** REST API for patient CRUD/search. */
@RestController
@RequestMapping("/api/v2/patienten")
public class PatientenController {
    private final PatientServiceImpl patientService;

    public PatientenController(PatientServiceImpl patientService) { this.patientService = patientService; }

    @GetMapping
    public List<PatientDto> list(@RequestParam(required = false) String q) {
        var data = (q == null || q.isBlank()) ? patientService.alle() : patientService.suchen(q);
        return data.stream().map(this::toDto).toList();
    }

    @PostMapping
    public PatientDto create(@RequestBody PatientDto dto) {
        return toDto(patientService.anlegen(fromDto(dto)));
    }

    @PutMapping("/{id}")
    public PatientDto update(@PathVariable UUID id, @RequestBody PatientDto dto) {
        return toDto(patientService.aktualisieren(id, fromDto(dto)));
    }

    private PatientDto toDto(Patient p) {
        return new PatientDto(p.getId(), p.getVersichertennummer(), p.getVorname(), p.getNachname(), p.getGeburtsdatum(), p.getAdresse(),
                p.getPlz(), p.getOrt(), p.getKrankenkasse(), p.getKassenname(), p.getAllergien(), p.getDauerdiagnosen(), p.isAktiv());
    }

    private Patient fromDto(PatientDto d) {
        return Patient.builder().id(d.id()).versichertennummer(d.versichertennummer()).vorname(d.vorname()).nachname(d.nachname())
                .geburtsdatum(d.geburtsdatum()).adresse(d.adresse()).plz(d.plz()).ort(d.ort()).krankenkasse(d.krankenkasse())
                .kassenname(d.kassenname()).allergien(d.allergien()).dauerdiagnosen(d.dauerdiagnosen()).aktiv(d.aktiv()).build();
    }
}
