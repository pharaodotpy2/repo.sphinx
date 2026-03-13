CREATE TABLE IF NOT EXISTS patients (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name TEXT,
    last_name TEXT,
    address TEXT,
    date_of_birth DATE,
    insurance_number TEXT UNIQUE,
    insurance_provider TEXT,
    insurance_type TEXT,
    allergies TEXT,
    chronic_conditions TEXT,
    medications TEXT,
    emergency_contact TEXT
);

CREATE TABLE IF NOT EXISTS audit_logs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    created_at TEXT,
    username TEXT,
    action TEXT,
    target TEXT,
    details TEXT
);
