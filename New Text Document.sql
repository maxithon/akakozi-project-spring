--1.department table
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE d_department (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name TEXT NOT NULL
);
INSERT INTO d_department (name) VALUES ('Human Resources');
SELECT * FROM d_department;

ALTER TABLE department ALTER COLUMN id SET DEFAULT gen_random_uuid();


--2.
CREATE TABLE d_employee (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    department_id UUID,
    CONSTRAINT fk_department FOREIGN KEY(department_id) REFERENCES d_department(id)
);

--3.
create table d_address (id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
street varchar(100)not null,city varchar(50)not null,zip varchar(50)not null); 