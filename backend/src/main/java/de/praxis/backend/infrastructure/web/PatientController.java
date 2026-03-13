package de.praxis.backend.infrastructure.web;

import de.praxis.backend.application.PatientService;
import de.praxis.backend.infrastructure.mapper.PatientMapper;
import de.praxis.core.dto.PatientRequest;
import de.praxis.core.dto.PatientResponse;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;
    private final PatientMapper mapper;

    public PatientController(PatientService service, PatientMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public PatientResponse create(@RequestBody PatientRequest request) {
        return mapper.toResponse(service.create(mapper.fromRequest(request)));
    }

    @PutMapping("/{id}")
    public PatientResponse update(@PathVariable Long id, @RequestBody PatientRequest request) {
        return mapper.toResponse(service.update(id, mapper.fromRequest(request)));
    }

    @GetMapping
    public List<PatientResponse> all(@RequestParam(required = false) String q) {
        var result = (q == null || q.isBlank()) ? service.all() : service.search(q);
        return result.stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/duplicate-hint")
    public String duplicateHint(@RequestParam String q) {
        return service.duplicateHint(q);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
