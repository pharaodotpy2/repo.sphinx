package de.praxis.core.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Domänenmodell für Terminverwaltung. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Termin {
    private UUID id;
    private UUID patientId;
    private UUID arztId;
    private LocalDateTime beginn;
    private LocalDateTime ende;
    private TerminTyp typ;
    private TerminStatus status;
    private String notizen;
    private boolean erinnerungGesendet;
}
