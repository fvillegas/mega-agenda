INSERT INTO users(id, username, password, created_at)
VALUES (nextval('user_seq'),
        'test',
        '$2y$10$X2Z.UHiBw92WMi/w1HvAO.cvP3wFk2H3DCyZMShe849f.DFNtCGvi',
        'now');