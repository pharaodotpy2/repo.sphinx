package de.praxis.core.dto;

import de.praxis.core.domain.InsuranceType;
import java.time.LocalDate;
import java.util.List;

/** DTO for patient API responses. */
public record PatientResponse(
        Long id,
        String firstName,
        String lastName,
        String address,
        LocalDate dateOfBirth,
        String insuranceNumber,
        String insuranceProvider,
        InsuranceType insuranceType,
        List<String> allergies,
        List<String> chronicConditions,
        List<String> medications,
        String emergencyContact) {}
