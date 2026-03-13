package de.praxis.core.service;

import de.praxis.core.model.Termin;
import java.time.LocalDate;
import java.util.List;

/** Servicevertrag für Terminkalenderlogik. */
public interface TerminService {
    Termin planen(Termin termin);
    List<Termin> tagesansicht(LocalDate tag);
}
