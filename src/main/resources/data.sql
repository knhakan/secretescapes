DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS transaction;

CREATE TABLE accounts (
  account_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  balance INT NOT NULL,
  emailaddress VARCHAR(250) NOT NULL
);
CREATE TABLE transaction (
  transaction_id INT AUTO_INCREMENT  PRIMARY KEY,
  amount INT,
  from_account INT,
  to_account INT
);

INSERT INTO accounts (name, balance, emailaddress)
VALUES  ('Michael Scott', '200', 'michael.scott@gmail.com'),
  ('Dwight Schrute', '200', 'dwight.schrute@gmail.com'),
  ('Jim Halpert', '200', 'jim.halpert@gmail.com'),
  ('Kevin Malone', '200', 'kevin.malone@gmail.com'),
  ('Pam Beesly', '200', 'pam.beesly@gmail.com'),
  ('Toby Flenderson', '200', 'toby.flenderson@gmail.com'),
  ('Erin Hannon', '200', 'erin.hannon@gmail.com');
