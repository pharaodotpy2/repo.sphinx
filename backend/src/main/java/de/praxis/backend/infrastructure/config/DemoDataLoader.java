package de.praxis.backend.infrastructure.config;

import de.praxis.backend.application.PatientService;
import de.praxis.core.domain.InsuranceType;
import de.praxis.core.domain.Patient;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDataLoader {
    @Bean
    CommandLineRunner seedPatients(PatientService service) {
        return args -> {
            if (service.all().isEmpty()) {
                service.create(Patient.builder()
                        .firstName("Anna")
                        .lastName("Schmidt")
                        .address("Musterstraße 1, Berlin")
                        .dateOfBirth(LocalDate.of(1990, 5, 12))
                        .insuranceNumber("AOK-123456")
                        .insuranceProvider("AOK")
                        .insuranceType(InsuranceType.GKV)
                        .allergies(List.of("Penicillin"))
                        .chronicConditions(List.of("Asthma"))
                        .medications(List.of("Salbutamol"))
                        .emergencyContact("Max Schmidt")
                        .build());
            }
        };
    }
}
