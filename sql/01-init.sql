CREATE TABLE IF NOT EXISTS users (
                                     id UUID PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL,
    internal_id BIGSERIAL NOT NULL
    );

 CREATE TABLE IF NOT EXISTS purchases (
                                         purchase_id UUID PRIMARY KEY,
                                         internal_id BIGSERIAL NOT NULL,
                                         user_id UUID NOT NULL,
                                         purchase_timestamp TIMESTAMP NOT NULL,
                                         price NUMERIC(19,8) NOT NULL,
    quantity NUMERIC(30,0) NOT NULL,
    usd_amount NUMERIC(19,2) NOT NULL,
    local_currency_amount NUMERIC(19,2) NOT NULL,
    coin VARCHAR(16) NOT NULL,
    fiat_currency VARCHAR(3) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id)
    REFERENCES users(id)
    );

  CREATE INDEX IF NOT EXISTS idx_purchases_user_id ON purchases(user_id);

 CREATE INDEX IF NOT EXISTS idx_purchases_user_timestamp ON purchases(user_id, purchase_timestamp);