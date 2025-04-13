INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'E44', 'Šarafciger', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'E45', 'Šaraf', 5.0, 'kom');
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B01', 'Mašina 1', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B02', 'Mašina 2', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B03', 'Mašina 3', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B04', 'Mašina 4', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B05', 'Mašina 5', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B06', 'Mašina 6', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B07', 'Mašina 7', 5.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B08', 'Mašina 8', 0.0, 'kom' );
INSERT INTO "artikl"("id", "sifra", "naziv", "stanje", "jedinica") VALUES(nextval('artikl_seq'), 'B08', 'Mašina 9', 1.0, 'kom' );


INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Marković d.o.o.', 'Spasovdanska 34', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Laguna', 'Vuka Karadžića 13', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Bingo', 'V. R. Putnika 55', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Comtrade d.o.o.', 'Beogradska 34', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Onogošt', 'Stefana Nemanje 13', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'LK group', 'Kasindolskog bataljona 55', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Stanić d.o.o.', 'Hilandarska 34', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Petrović d.o.o.', 'Zmaj Jovina 1', '71 123', 'Istočno Sarajevo');
INSERT INTO "kupac"("id", "naziv", "adresa", "postanski_broj", "grad") VALUES(nextval('kupac_seq'), 'Lukić d.o.o.', 'Trg Republike Srbije 11', '71 123', 'Istočno Sarajevo');


INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen") VALUES(nextval('nalog_seq'), 'RN-01', '25.03.2025.', 1, true);
INSERT INTO "nalog"("id", "broj", "datum", "kupac", "zavrsen") VALUES(nextval('nalog_seq'), 'RN-02', null, 1, false);

INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 1,'E44', 'Šarafciger', 5, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 1,'E45', 'Šaraf', 3, 'kom');
INSERT INTO "stavka"("id", "nalog", "sifra", "artikl", "kolicina", "jedinica") VALUES(nextval('stavka_seq'), 2,'E45', 'Šaraf', 3, 'kom');
