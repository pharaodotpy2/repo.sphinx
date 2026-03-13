package de.praxis.cardreader.api;

import java.time.LocalDate;

/** Result payload from eGK/KVK read operation. */
public record CardReadResult(
        String insuranceNumber,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String insuranceProvider,
        boolean valid,
        String message) {}
