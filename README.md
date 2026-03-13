# Praxisverwaltungssystem — Sterile Agility (Java 21)

Produktionsnahes, modulares Praxisverwaltungssystem für **Windows 10/11** (primär) und Linux (sekundär), basierend auf **Java 21**, **JavaFX 21**, **Spring Boot 3.2** und **Maven 3.9+**.

## Highlights
- Multi-Module-Architektur: `core`, `backend`, `frontend`, `cardreader`, `ai`
- JavaFX Desktop UI mit **Sterile Agility** Designsystem (Dark Clinical Theme)
- Embedded Spring Boot Backend (kein externer App-Server)
- SQLite (Default) + optionale PostgreSQL-Umschaltung
- Flyway Migrationen **V1–V5**
- Demo-Seed: 50 Patienten + Termine beim Erststart
- KI-Provider-Architektur (Mock/OpenAI/Claude/Ollama-ready)
- Kartenleser-Abstraktion (eGK/PCSC, Fallback-Pfade)

## Projektstruktur

```text
praxisverwaltung/
├── pom.xml
├── core/
├── backend/
├── frontend/
├── cardreader/
└── ai/
```

## Voraussetzungen
- Java 21
- Maven 3.9+
- Windows: installierte Smartcard/PCSC-Treiber für Kartenleser (z. B. Cherry ST-1200, ORGA 6141, Ingenico)

## Build

```bash
mvn clean install
```

## Starten

Backend:
```bash
mvn -pl backend spring-boot:run
```

Frontend:
```bash
mvn -pl frontend javafx:run
```

## Konfiguration

Datei: `backend/src/main/resources/application.yml`

- SQLite (default): `jdbc:sqlite:${user.home}/.praxisverwaltung/praxis.db`
- Logging: `${user.home}/.praxisverwaltung/logs`
- AI-Provider: `praxis.ai.provider` (z. B. `mock`, `openai`, `claude`, `ollama`)

### PostgreSQL umschalten (optional)
- `spring.datasource.url=jdbc:postgresql://...`
- `spring.datasource.driver-class-name=org.postgresql.Driver`
- `hibernate dialect` entsprechend Postgres setzen

## Kartenleser Setup (Windows)
1. PCSC/Smartcard-Treiber des Herstellers installieren.
2. Kartenleser an USB anschließen und im Gerätemanager prüfen.
3. Anwendung starten und im Bereich Einstellungen → Kartenleser testen.
4. Falls kein Leser verfügbar: manuelle Erfassung/Fallback bleibt nutzbar.

## UI Designsystem: Sterile Agility
- CSS aufgeteilt in:
  - `css/base.css` (Token/Farben/Typografie)
  - `css/layout.css` (Sidebar/Topbar/Grid)
  - `css/components.css` (Buttons, Inputs, Tabellen, Panels)
- Asymmetrisches Layout: 240px Sidebar + Main Content
- 8px Grid, kompakte datendichte Panels, dezente Hairline-Borders

## Enthaltene MVP-Funktionen
- Dashboard-Shell mit KPI-Karten und Aktivitätsbereichen
- Patientenverwaltung (Service-/Repository-Architektur, REST-V2 Endpoint)
- Terminplanung mit Konflikterkennung
- Flyway-Schema inkl. Indizes für performante Suche
- Audit/AI/Backup-Schema-Tabellen vorbereitet

## Tests
- Service-Tests für Patienten- und Terminlogik
- AI/Cardreader-Basistests aus den jeweiligen Modulen

## Hinweis
In restriktiven Umgebungen ohne Zugriff auf Maven Central kann der Build scheitern, obwohl das Projekt strukturell vollständig konfiguriert ist.
