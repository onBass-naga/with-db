
CREATE DATABASE sample;

\c sample

DROP TABLE IF EXISTS members;
CREATE TABLE members (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birthday DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE members_id_seq START 1;

INSERT INTO members (id, name) VALUES(nextval('members_id_seq'), 'Ash');
