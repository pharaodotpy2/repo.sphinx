package de.praxis.backend.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import de.praxis.core.model.Termin;
import de.praxis.core.repository.TerminRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TerminServiceImplTest {
    @Test
    void planenRejectsConflict() {
        TerminRepository repo = Mockito.mock(TerminRepository.class);
        UUID arzt = UUID.randomUUID();
        when(repo.findByDatum(anyDate())).thenReturn(List.of(Termin.builder()
                .arztId(arzt)
                .beginn(LocalDateTime.of(2025,1,1,10,0))
                .ende(LocalDateTime.of(2025,1,1,10,30)).build()));
        TerminServiceImpl service = new TerminServiceImpl(repo);
        Termin request = Termin.builder().arztId(arzt).beginn(LocalDateTime.of(2025,1,1,10,15)).ende(LocalDateTime.of(2025,1,1,10,45)).build();
        assertThrows(IllegalStateException.class, () -> service.planen(request));
    }

    private java.time.LocalDate anyDate() { return java.time.LocalDate.of(2025,1,1); }
}
