package de.praxis.backend.entity;

import de.praxis.core.model.TerminStatus;
import de.praxis.core.model.TerminTyp;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "termine")
@Getter
@Setter
public class TerminRecord {
    @Id
    private UUID id;
    private UUID patientId;
    private UUID arztId;
    private LocalDateTime beginn;
    private LocalDateTime ende;
    @Enumerated(EnumType.STRING)
    private TerminTyp typ;
    @Enumerated(EnumType.STRING)
    private TerminStatus status;
    private String notizen;
    private boolean erinnerungGesendet;
}
