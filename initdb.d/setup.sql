CREATE TABLE person
(
    id UUID PRIMARY KEY,
    name VARCHAR(16),
    metadata JSONB,
    params JSONB
);
