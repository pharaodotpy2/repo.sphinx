CREATE TABLE IF NOT EXISTS patienten (
  id TEXT PRIMARY KEY,
  versichertennummer TEXT NOT NULL UNIQUE,
  vorname TEXT,
  nachname TEXT,
  geburtsdatum DATE,
  adresse TEXT,
  plz TEXT,
  ort TEXT,
  krankenkasse TEXT,
  kassenname TEXT,
  allergien TEXT,
  dauerdiagnosen TEXT,
  medikamente TEXT,
  erstellt_am TEXT,
  geaendert_am TEXT,
  aktiv BOOLEAN DEFAULT 1
);

CREATE TABLE IF NOT EXISTS termine (
  id TEXT PRIMARY KEY,
  patient_id TEXT,
  arzt_id TEXT,
  beginn TEXT,
  ende TEXT,
  typ TEXT,
  status TEXT,
  notizen TEXT,
  erinnerung_gesendet BOOLEAN DEFAULT 0
);
