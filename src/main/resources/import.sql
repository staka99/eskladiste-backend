INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'E44', 'Šarafciger', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'E45', 'Šaraf', 5.0, 'kom');
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B01', 'Mašina 1', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B02', 'Mašina 2', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B03', 'Mašina 3', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B04', 'Mašina 4', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B05', 'Mašina 5', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B06', 'Mašina 6', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B07', 'Mašina 7', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B08', 'Mašina 8', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B08', 'Mašina 9', 0.0, 'kom' );


INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Marković d.o.o.', 'Spasovdanska 34', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Laguna', 'Vuka Karadžića 13', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Bingo', 'V. R. Putnika 55', '71 123', 'Istočno Sarajevo');


INSERT INTO "transakcija"("id", "datum", "kolicina", "opis", "artikl") VALUES(nextval('transakcija_seq'), '25.03.2025.',  15.0, 'Opis', 1);
INSERT INTO "transakcija"("id", "datum", "kolicina", "opis", "artikl") VALUES(nextval('transakcija_seq'), '24.03.2025.',  5.0, 'Opis', 1);