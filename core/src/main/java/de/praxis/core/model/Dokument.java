package de.praxis.core.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Domänenmodell für Dokumente. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dokument {
    private UUID id;
    private UUID patientId;
    private DokumentTyp typ;
    private String titel;
    private byte[] inhalt;
    private LocalDateTime erstelltAm;
}
