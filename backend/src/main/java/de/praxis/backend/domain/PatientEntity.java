package de.praxis.backend.domain;

import de.praxis.core.domain.InsuranceType;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "insurance_number", unique = true)
    private String insuranceNumber;
    @Column(name = "insurance_provider")
    private String insuranceProvider;
    @Enumerated(EnumType.STRING)
    @Column(name = "insurance_type")
    private InsuranceType insuranceType;
    @Column(length = 3000)
    private String allergies;
    @Column(length = 3000)
    @Column(name = "chronic_conditions", length = 3000)
    private String chronicConditions;
    @Column(length = 3000)
    private String medications;
    @Column(name = "emergency_contact")
    private String emergencyContact;
}
