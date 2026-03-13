package de.praxis.backend.repository.impl;

import de.praxis.backend.entity.TerminRecord;
import de.praxis.core.model.Termin;
import de.praxis.core.repository.TerminRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/** JPA-backed appointment repository implementation. */
@Repository
public class TerminRepositoryImpl implements TerminRepository {
    private final SpringTerminRecordRepository repository;

    public TerminRepositoryImpl(SpringTerminRecordRepository repository) { this.repository = repository; }

    @Override
    public Termin save(Termin termin) {
        TerminRecord r = new TerminRecord();
        r.setId(termin.getId() == null ? UUID.randomUUID() : termin.getId());
        r.setPatientId(termin.getPatientId());
        r.setArztId(termin.getArztId());
        r.setBeginn(termin.getBeginn());
        r.setEnde(termin.getEnde());
        r.setTyp(termin.getTyp());
        r.setStatus(termin.getStatus());
        r.setNotizen(termin.getNotizen());
        r.setErinnerungGesendet(termin.isErinnerungGesendet());
        repository.save(r);
        termin.setId(r.getId());
        return termin;
    }

    @Override
    public List<Termin> findByDatum(LocalDate datum) {
        return repository.findByBeginnBetween(datum.atStartOfDay(), datum.plusDays(1).atStartOfDay()).stream().map(this::toDomain).toList();
    }

    @Override
    public List<Termin> findByPatientId(UUID patientId) {
        return repository.findByPatientId(patientId).stream().map(this::toDomain).toList();
    }

    private Termin toDomain(TerminRecord r) {
        return Termin.builder().id(r.getId()).patientId(r.getPatientId()).arztId(r.getArztId()).beginn(r.getBeginn()).ende(r.getEnde())
                .typ(r.getTyp()).status(r.getStatus()).notizen(r.getNotizen()).erinnerungGesendet(r.isErinnerungGesendet()).build();
    }
}
