--department table
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE d_department (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name TEXT NOT NULL
);
INSERT INTO d_department (name) VALUES ('Human Resources');
SELECT * FROM d_department;

ALTER TABLE department ALTER COLUMN id SET DEFAULT gen_random_uuid();