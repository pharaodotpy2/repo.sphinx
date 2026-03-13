package de.praxis.core.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Value;

/**
 * Patient aggregate root used by application services.
 */
@Value
@Builder(toBuilder = true)
public class Patient {
    Long id;
    String firstName;
    String lastName;
    String address;
    LocalDate dateOfBirth;
    String insuranceNumber;
    String insuranceProvider;
    InsuranceType insuranceType;
    List<String> allergies;
    List<String> chronicConditions;
    List<String> medications;
    String emergencyContact;
}
