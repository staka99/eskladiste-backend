DELETE 

INSERT INTO company (id, name)
SELECT nextval('company_seq'), 'T&M'
WHERE NOT EXISTS (SELECT 1 FROM company WHERE name = 'T&M');

INSERT INTO company (id, name)
SELECT nextval('company_seq'), 'Bralis'
WHERE NOT EXISTS (SELECT 1 FROM company WHERE name = 'Bralis');

INSERT INTO artikl (id, sifra, naziv, jedinica, stanje, cijena, company)
SELECT nextval('artikl_seq'), 'Test X', 'Test X', 'X', 0, 0, 2
WHERE NOT EXISTS (SELECT 1 FROM artikl WHERE naziv = 'Test X');

INSERT INTO artikl (id, sifra, naziv, jedinica, stanje, cijena, company)
SELECT nextval('artikl_seq'), 'Test xx', 'Test xx', 'X', 0, 0, 2
WHERE NOT EXISTS (SELECT 1 FROM artikl WHERE naziv = 'Test xx');

INSERT INTO app_user (id, username, password, role, company)
SELECT nextval('user_seq'), 'staka99', '$2a$12$sBaK1/urTjFs7bQPj92MvOlo1p03DCShAcfQY.20MluQRZEMwT6lq', 'ADMIN', 1
WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'staka99');

INSERT INTO app_user (id, username, password, role, company)
SELECT nextval('user_seq'), 'zeljana', '$2a$12$/LN21Vr9OJwNZO7T1Sy/AeQGKVXVO2VLVyq0gSBAd1vq4iUxCkB1y', 'USER', 2
WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'zeljana');

INSERT INTO app_user (id, username, password, role, company)
SELECT nextval('user_seq'), 'gagi', '$2a$12$RDzxxX.tDnXfLEIGiLjEE.IGK9xaNgGZF1aRH1qlg212KrUflQEBu', 'USER', 2
WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'gagi');

INSERT INTO app_user (id, username, password, role, company)
SELECT nextval('user_seq'), 'milan', '$2a$12$OvxAkYkrl0overg37AxVauuysjv7sMAftKoru3gFVGAQYyEJ7Fwfi', 'USER', 2
WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'milan');
