package de.praxis.backend.config;

import de.praxis.core.model.Krankenkasse;
import de.praxis.core.model.Patient;
import de.praxis.core.model.Termin;
import de.praxis.core.model.TerminStatus;
import de.praxis.core.model.TerminTyp;
import de.praxis.core.service.PatientService;
import de.praxis.core.service.TerminService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Seeds demo dataset on first startup (50 patients + appointments). */
@Component
public class DemoDataService implements CommandLineRunner {
    private final PatientService patientService;
    private final TerminService terminService;

    public DemoDataService(PatientService patientService, TerminService terminService) {
        this.patientService = patientService;
        this.terminService = terminService;
    }

    @Override
    public void run(String... args) {
        if (!patientService.alle().isEmpty()) return;
        UUID arzt = UUID.randomUUID();
        for (int i = 1; i <= 50; i++) {
            Patient p = patientService.anlegen(Patient.builder()
                    .versichertennummer("KV" + String.format("%08d", i))
                    .vorname("Patient" + i)
                    .nachname("Demo")
                    .geburtsdatum(LocalDate.of(1965 + (i % 30), (i % 12) + 1, (i % 27) + 1))
                    .adresse("Musterweg " + i)
                    .plz("10" + String.format("%03d", i))
                    .ort("Berlin")
                    .krankenkasse(i % 2 == 0 ? Krankenkasse.GKV : Krankenkasse.PKV)
                    .kassenname(i % 2 == 0 ? "AOK" : "Debeka")
                    .allergien(List.of("Keine"))
                    .dauerdiagnosen(List.of("I10"))
                    .aktiv(true)
                    .build());
            terminService.planen(Termin.builder()
                    .patientId(p.getId())
                    .arztId(arzt)
                    .beginn(LocalDateTime.now().plusDays(i % 7).withHour(8 + (i % 8)).withMinute(0))
                    .ende(LocalDateTime.now().plusDays(i % 7).withHour(8 + (i % 8)).withMinute(30))
                    .typ(TerminTyp.KONTROLLE)
                    .status(TerminStatus.GEPLANT)
                    .notizen("Seed")
                    .erinnerungGesendet(false)
                    .build());
        }
    }
}
