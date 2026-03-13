package de.praxis.backend.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.praxis.ai.service.AIOrchestrator;
import de.praxis.core.domain.Patient;
import de.praxis.core.ports.AuditPort;
import de.praxis.core.ports.PatientRepositoryPort;
import de.praxis.core.security.AuditContext;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PatientServiceTest {
    @Test
    void shouldCreatePatientAndAudit() {
        PatientRepositoryPort repo = Mockito.mock(PatientRepositoryPort.class);
        AuditPort audit = Mockito.mock(AuditPort.class);
        AuditContext context = () -> "tester";
        AIOrchestrator ai = Mockito.mock(AIOrchestrator.class);
        when(repo.save(any())).thenAnswer(i -> i.getArguments()[0]);

        PatientService service = new PatientService(repo, audit, context, ai);
        Patient p = Patient.builder().firstName("Max").lastName("Muster").build();

        Patient saved = service.create(p);

        assertEquals("Max", saved.getFirstName());
        verify(audit).logAccess(any(), any(), any(), any());
    }

    @Test
    void shouldListPatients() {
        PatientRepositoryPort repo = Mockito.mock(PatientRepositoryPort.class);
        AuditPort audit = Mockito.mock(AuditPort.class);
        AIOrchestrator ai = Mockito.mock(AIOrchestrator.class);
        when(repo.findAll()).thenReturn(List.of(Patient.builder().firstName("A").build()));
        PatientService service = new PatientService(repo, audit, () -> "tester", ai);
        assertEquals(1, service.all().size());
    }
}
