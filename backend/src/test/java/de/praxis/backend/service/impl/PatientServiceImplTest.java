package de.praxis.backend.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import de.praxis.core.model.Patient;
import de.praxis.core.repository.PatientRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PatientServiceImplTest {
    @Test
    void anlegenSetsDefaults() {
        PatientRepository repo = Mockito.mock(PatientRepository.class);
        when(repo.save(any())).thenAnswer(i -> i.getArgument(0));
        PatientServiceImpl service = new PatientServiceImpl(repo);

        Patient saved = service.anlegen(Patient.builder().vorname("Max").build());

        assertNotNull(saved.getId());
        assertNotNull(saved.getErstelltAm());
    }

    @Test
    void suchenDelegates() {
        PatientRepository repo = Mockito.mock(PatientRepository.class);
        when(repo.search("abc")).thenReturn(List.of(Patient.builder().vorname("A").build()));
        PatientServiceImpl service = new PatientServiceImpl(repo);
        assertEquals(1, service.suchen("abc").size());
    }
}
