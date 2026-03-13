CREATE TABLE IF NOT EXISTS audit_log (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  created_at TEXT,
  username TEXT,
  action TEXT,
  target TEXT,
  details TEXT
);

CREATE TABLE IF NOT EXISTS ai_call_log (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  created_at TEXT,
  provider TEXT,
  use_case TEXT,
  prompt_excerpt TEXT,
  success BOOLEAN
);
