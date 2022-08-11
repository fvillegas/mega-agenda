CREATE TABLE users
(
    id       BIGINT NOT NULL,
    UUID     uuid UNIQUE,
    username TEXT,
    password TEXT
);

ALTER TABLE users
    ADD PRIMARY KEY (id);

CREATE SEQUENCE user_seq;
