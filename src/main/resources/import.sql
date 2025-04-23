INSERT INTO "company"("id", "name") VALUES(nextval('company_seq'), 'T&M');
INSERT INTO "company"("id", "name") VALUES(nextval('company_seq'), 'Bralis');

INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'E44', 'Šaraf 1', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'E45', 'Šaraf 2', 5.0, 'kom', 2);
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B01', 'Mašina 1', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B02', 'Mašina 2', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B03', 'Mašina 3', 5.0, 'kom', 2);
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B04', 'Mašina 4', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B05', 'Mašina 5', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B06', 'Mašina 6', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B07', 'Mašina 7', 5.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B08', 'Mašina 8', 0.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B09', 'Mašina 9', 1.0, 'kom', 2 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B01', 'Jafa keks', 1.0, 'kom', 1 );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica", "company") VALUES(nextval('artikl_seq'), 'B02', 'Štark napolitanka', 1.0, 'kom', 1 );


INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'T&M', 'Spasovdanska 34', '71 123', 'Istočno Sarajevo', 1);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Marković d.o.o.', 'Spasovdanska 34', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Laguna', 'Vuka Karadžića 13', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Bingo', 'V. R. Putnika 55', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Comtrade d.o.o.', 'Beogradska 34', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Onogošt', 'Stefana Nemanje 13', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'LK group', 'Kasindolskog bataljona 55', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Stanić d.o.o.', 'Hilandarska 34', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Petrović d.o.o.', 'Zmaj Jovina 1', '71 123', 'Istočno Sarajevo', 2);
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad", "company") VALUES(nextval('kupac_seq'), 'Lukić d.o.o.', 'Trg Republike Srbije 11', '71 123', 'Istočno Sarajevo', 2);


INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen", "company") VALUES(nextval('nalog_seq'), 'Test-01', '25.03.2025.', 1, true, 1);
INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen", "company") VALUES(nextval('nalog_seq'), 'Test-02', null, 1, false, 1);
INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen", "company") VALUES(nextval('nalog_seq'), 'RN-01', '25.03.2025.', 3, true, 2);
INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen", "company") VALUES(nextval('nalog_seq'), 'RN-02', null, 3, false, 2);

INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 1,'E44', 'Šarafciger', 5, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 1,'E45', 'Šaraf', 3, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 2,'E45', 'Šaraf', 3, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 3,'E44', 'Šarafciger', 5, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 3,'E45', 'Šaraf', 3, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 4,'E45', 'Šaraf', 3, 'kom');

INSERT INTO app_user (id, username, password, role, company) SELECT nextval('user_seq'), 'staka99', '$2a$12$sBaK1/urTjFs7bQPj92MvOlo1p03DCShAcfQY.20MluQRZEMwT6lq', 'ADMIN', 1 WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'staka99');
INSERT INTO app_user (id, username, password, role, company) SELECT nextval('user_seq'), 'slavko', '$2a$10$cRpHu5CZHllbet5U8k/hVuO03GBxMS5/U7eelQ2CxuyJXehjI2ZJS', 'USER', 2 WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'slavko');
INSERT INTO app_user (id, username, password, role, company) SELECT nextval('user_seq'), 'marko', '$2a$10$cRpHu5CZHllbet5U8k/hVuO03GBxMS5/U7eelQ2CxuyJXehjI2ZJS', 'USER', 2 WHERE NOT EXISTS (SELECT 1 FROM app_user WHERE username = 'marko');
