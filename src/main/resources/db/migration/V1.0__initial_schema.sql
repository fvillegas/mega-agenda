SET timezone TO 'UTC';

CREATE TABLE users
(
    id       BIGINT NOT NULL,
    UUID     uuid UNIQUE,
    username TEXT UNIQUE,
    password TEXT,
    created_at TIMESTAMP
);

ALTER TABLE users
    ADD PRIMARY KEY (id);

CREATE SEQUENCE user_seq;
