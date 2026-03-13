CREATE INDEX IF NOT EXISTS idx_patienten_name ON patienten(nachname, vorname);
CREATE INDEX IF NOT EXISTS idx_patienten_versichertennummer ON patienten(versichertennummer);
CREATE INDEX IF NOT EXISTS idx_termine_beginn ON termine(beginn);
