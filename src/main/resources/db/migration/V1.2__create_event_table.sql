CREATE TABLE events
(
    id       BIGINT NOT NULL,
    name TEXT
);

ALTER TABLE events
    ADD PRIMARY KEY (id);

CREATE SEQUENCE events_seq;
