package de.praxis.backend.repository.impl;

import de.praxis.backend.entity.PatientRecord;
import de.praxis.core.model.Medikament;
import de.praxis.core.model.Patient;
import de.praxis.core.repository.PatientRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/** JPA-backed patient repository implementation. */
@Repository
public class PatientRepositoryImpl implements PatientRepository {
    private final SpringPatientRecordRepository repository;

    public PatientRepositoryImpl(SpringPatientRecordRepository repository) { this.repository = repository; }

    @Override
    public Patient save(Patient p) {
        PatientRecord e = toEntity(p);
        repository.save(e);
        return toDomain(e);
    }

    @Override
    public Optional<Patient> findById(UUID id) { return repository.findById(id).map(this::toDomain); }

    @Override
    public List<Patient> findAll() { return repository.findAll().stream().map(this::toDomain).toList(); }

    @Override
    public List<Patient> search(String query) {
        return repository.findByVornameContainingIgnoreCaseOrNachnameContainingIgnoreCaseOrVersichertennummerContainingIgnoreCase(query, query, query)
                .stream().map(this::toDomain).toList();
    }

    private PatientRecord toEntity(Patient p) {
        PatientRecord e = new PatientRecord();
        e.setId(p.getId() == null ? UUID.randomUUID() : p.getId());
        e.setVersichertennummer(p.getVersichertennummer());
        e.setVorname(p.getVorname());
        e.setNachname(p.getNachname());
        e.setGeburtsdatum(p.getGeburtsdatum());
        e.setAdresse(p.getAdresse());
        e.setPlz(p.getPlz());
        e.setOrt(p.getOrt());
        e.setKrankenkasse(p.getKrankenkasse());
        e.setKassenname(p.getKassenname());
        e.setAllergien(join(p.getAllergien()));
        e.setDauerdiagnosen(join(p.getDauerdiagnosen()));
        e.setMedikamente(p.getMedikamente() == null ? "" : p.getMedikamente().stream().map(Medikament::getName).reduce((a,b)->a+"|"+b).orElse(""));
        e.setErstelltAm(p.getErstelltAm());
        e.setGeaendertAm(p.getGeaendertAm());
        e.setAktiv(p.isAktiv());
        return e;
    }

    private Patient toDomain(PatientRecord e) {
        return Patient.builder().id(e.getId()).versichertennummer(e.getVersichertennummer()).vorname(e.getVorname()).nachname(e.getNachname())
                .geburtsdatum(e.getGeburtsdatum()).adresse(e.getAdresse()).plz(e.getPlz()).ort(e.getOrt())
                .krankenkasse(e.getKrankenkasse()).kassenname(e.getKassenname()).allergien(split(e.getAllergien()))
                .dauerdiagnosen(split(e.getDauerdiagnosen())).medikamente(List.of()).erstelltAm(e.getErstelltAm()).geaendertAm(e.getGeaendertAm()).aktiv(e.isAktiv()).build();
    }

    private String join(List<String> values) { return values == null ? "" : String.join("|", values); }
    private List<String> split(String value) { return value == null || value.isBlank() ? List.of() : Arrays.asList(value.split("\\|")); }
}
