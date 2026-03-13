package de.praxis.backend.infrastructure.persistence;

import de.praxis.backend.infrastructure.mapper.PatientMapper;
import de.praxis.core.domain.Patient;
import de.praxis.core.ports.PatientRepositoryPort;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryAdapter implements PatientRepositoryPort {
    private final SpringPatientJpaRepository repository;
    private final PatientMapper mapper;

    public PatientRepositoryAdapter(SpringPatientJpaRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient patient) {
        var entity = mapper.toEntity(patient);
        entity.setId(patient.getId());
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Patient> search(String query) {
        return repository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrInsuranceNumberContainingIgnoreCase(query, query, query)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
