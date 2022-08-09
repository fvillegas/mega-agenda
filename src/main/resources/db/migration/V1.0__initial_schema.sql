CREATE TABLE userModels
(
    id       BIGINT NOT NULL,
    UUID     uuid UNIQUE,
    username TEXT,
    password TEXT
);

ALTER TABLE userModels
    ADD PRIMARY KEY (id);

CREATE SEQUENCE user_seq;
