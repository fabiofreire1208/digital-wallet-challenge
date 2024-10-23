CREATE TABLE IF NOT EXISTS clients(
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  document VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  phone VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS accounts(
  id UUID NOT NULL PRIMARY KEY,
  number VARCHAR(255) NOT NULL,
  client_id UUID NOT NULL,
  balance NUMERIC NOT NULL,
  CONSTRAINT fk_client
    FOREIGN KEY (client_id)
    REFERENCES clients(id)
    ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS transactions(
  id UUID NOT NULL PRIMARY KEY,
  account_from_id UUID NOT NULL,
  account_to_id UUID NOT NULL,
  amount NUMERIC NOT NULL,
  transaction_type VARCHAR(50),
  transaction_status VARCHAR(50),
  transaction_creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  transaction_update_date TIMESTAMP,

  CONSTRAINT fk_account_from
    FOREIGN KEY (account_from_id)
    REFERENCES accounts(id)
    ON DELETE CASCADE,

  CONSTRAINT fk_account_to
      FOREIGN KEY (account_to_id)
      REFERENCES accounts(id)
      ON DELETE CASCADE
);