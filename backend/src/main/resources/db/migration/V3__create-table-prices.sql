CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE prices (
    id SERIAL PRIMARY KEY,
    id_market SERIAL NOT NULL,
    id_product SERIAL NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    last_actualization_date DATE NOT NULL,
    FOREIGN KEY (id_market) REFERENCES markets(id),
    FOREIGN KEY (id_product) REFERENCES products(id)
);