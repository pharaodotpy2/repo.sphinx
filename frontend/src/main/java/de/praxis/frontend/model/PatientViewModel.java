package de.praxis.frontend.model;

import java.time.LocalDate;

public record PatientViewModel(Long id, String firstName, String lastName, String insuranceNumber, LocalDate dob) {}
