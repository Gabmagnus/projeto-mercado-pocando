CREATE TABLE markets (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    image VARCHAR(255)
);