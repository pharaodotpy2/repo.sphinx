CREATE TABLE IF NOT EXISTS praxis_settings (
  key TEXT PRIMARY KEY,
  value TEXT
);

CREATE TABLE IF NOT EXISTS backup_runs (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  created_at TEXT,
  target TEXT,
  success BOOLEAN,
  details TEXT
);
