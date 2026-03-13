package de.praxis.backend.infrastructure.mapper;

import de.praxis.backend.domain.PatientEntity;
import de.praxis.core.domain.Patient;
import de.praxis.core.dto.PatientRequest;
import de.praxis.core.dto.PatientResponse;
import java.util.Arrays;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(target = "allergies", expression = "java(join(patient.allergies()))")
    @Mapping(target = "chronicConditions", expression = "java(join(patient.chronicConditions()))")
    @Mapping(target = "medications", expression = "java(join(patient.medications()))")
    PatientEntity toEntity(Patient patient);

    @Mapping(target = "allergies", expression = "java(split(entity.getAllergies()))")
    @Mapping(target = "chronicConditions", expression = "java(split(entity.getChronicConditions()))")
    @Mapping(target = "medications", expression = "java(split(entity.getMedications()))")
    Patient toDomain(PatientEntity entity);

    default Patient fromRequest(PatientRequest request) {
        return Patient.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .address(request.address())
                .dateOfBirth(request.dateOfBirth())
                .insuranceNumber(request.insuranceNumber())
                .insuranceProvider(request.insuranceProvider())
                .insuranceType(request.insuranceType())
                .allergies(request.allergies())
                .chronicConditions(request.chronicConditions())
                .medications(request.medications())
                .emergencyContact(request.emergencyContact())
                .build();
    }

    default PatientResponse toResponse(Patient patient) {
        return new PatientResponse(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAddress(),
                patient.getDateOfBirth(), patient.getInsuranceNumber(), patient.getInsuranceProvider(),
                patient.getInsuranceType(), patient.getAllergies(), patient.getChronicConditions(),
                patient.getMedications(), patient.getEmergencyContact());
    }

    default String join(List<String> values) { return values == null ? "" : String.join("|", values); }
    default List<String> split(String value) { return value == null || value.isBlank() ? List.of() : Arrays.asList(value.split("\\|")); }
}
