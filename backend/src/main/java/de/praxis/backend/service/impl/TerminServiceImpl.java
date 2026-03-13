package de.praxis.backend.service.impl;

import de.praxis.core.model.Termin;
import de.praxis.core.repository.TerminRepository;
import de.praxis.core.service.TerminService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/** Appointment scheduling service with conflict checks. */
@Service
public class TerminServiceImpl implements TerminService {
    private final TerminRepository repository;

    public TerminServiceImpl(TerminRepository repository) { this.repository = repository; }

    @Override
    public Termin planen(Termin termin) {
        List<Termin> sameDay = repository.findByDatum(termin.getBeginn().toLocalDate());
        boolean conflict = sameDay.stream().anyMatch(t -> t.getArztId().equals(termin.getArztId())
                && termin.getBeginn().isBefore(t.getEnde()) && termin.getEnde().isAfter(t.getBeginn()));
        if (conflict) throw new IllegalStateException("Terminkonflikt erkannt");
        termin.setId(termin.getId() == null ? UUID.randomUUID() : termin.getId());
        return repository.save(termin);
    }

    @Override
    public List<Termin> tagesansicht(LocalDate tag) { return repository.findByDatum(tag); }
}
