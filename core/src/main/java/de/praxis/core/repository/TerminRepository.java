package de.praxis.core.repository;

import de.praxis.core.model.Termin;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/** Repository-Abstraktion für Termine. */
public interface TerminRepository {
    Termin save(Termin termin);
    List<Termin> findByDatum(LocalDate datum);
    List<Termin> findByPatientId(UUID patientId);
}
