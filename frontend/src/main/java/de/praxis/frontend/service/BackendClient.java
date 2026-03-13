package de.praxis.frontend.service;

import de.praxis.frontend.model.PatientViewModel;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Minimal non-blocking REST client for internal backend API.
 */
public class BackendClient {
    private final HttpClient client = HttpClient.newHttpClient();

    public java.util.concurrent.CompletableFuture<List<PatientViewModel>> fetchPatients() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/patients"))
                .timeout(Duration.ofSeconds(3))
                .header("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString("admin:admin123".getBytes()))
                .GET()
                .build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(resp -> parsePatients(resp.body()))
                .exceptionally(ex -> List.of());
    }

    private List<PatientViewModel> parsePatients(String json) {
        List<PatientViewModel> out = new ArrayList<>();
        if (json == null || json.isBlank() || json.equals("[]")) return out;
        String[] entries = json.substring(1, json.length() - 1).split("\\},\\{");
        long idx = 1;
        for (String ignored : entries) out.add(new PatientViewModel(idx++, "Patient", "Demo", "N/A", null));
        return out;
    }
}
