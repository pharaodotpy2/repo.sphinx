package de.praxis.backend.service.impl;

import de.praxis.core.model.Patient;
import de.praxis.core.repository.PatientRepository;
import de.praxis.core.service.PatientService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/** Business logic for patient management. */
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) { this.repository = repository; }

    @Override
    public Patient anlegen(Patient patient) {
        patient.setId(patient.getId() == null ? UUID.randomUUID() : patient.getId());
        patient.setErstelltAm(LocalDateTime.now());
        patient.setGeaendertAm(LocalDateTime.now());
        patient.setAktiv(true);
        return repository.save(patient);
    }

    @Override
    public Patient aktualisieren(UUID id, Patient patient) {
        patient.setId(id);
        patient.setGeaendertAm(LocalDateTime.now());
        return repository.save(patient);
    }

    @Override
    public List<Patient> suchen(String query) { return repository.search(query == null ? "" : query); }

    @Override
    public List<Patient> alle() { return repository.findAll(); }
}
