package de.praxis.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Backend entry point for embedded Spring Boot runtime. */
@SpringBootApplication(scanBasePackages = "de.praxis")
public class PraxisBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(PraxisBackendApplication.class, args);
    }
}
