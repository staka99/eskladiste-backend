-- Sekvence
CREATE SEQUENCE IF NOT EXISTS company_seq;
CREATE SEQUENCE IF NOT EXISTS artikl_seq;
CREATE SEQUENCE IF NOT EXISTS kupac_seq;
CREATE SEQUENCE IF NOT EXISTS nalog_seq;
CREATE SEQUENCE IF NOT EXISTS stavka_seq;
CREATE SEQUENCE IF NOT EXISTS user_seq;

-- Company
CREATE TABLE IF NOT EXISTS public.company (
    id BIGINT PRIMARY KEY DEFAULT nextval('company_seq'),
    name VARCHAR(255)
);

-- Artikl
CREATE TABLE IF NOT EXISTS public.artikl (
    id BIGINT PRIMARY KEY DEFAULT nextval('artikl_seq'),
    sifra VARCHAR(255),
    naziv VARCHAR(255),
    stanje DOUBLE PRECISION,
    jedinica VARCHAR(50),
    cijena DOUBLE PRECISION,
    company BIGINT REFERENCES public.company(id)
);

-- Kupac
CREATE TABLE IF NOT EXISTS public.kupac (
    id BIGINT PRIMARY KEY DEFAULT nextval('kupac_seq'),
    jib VARCHAR(50),
    naziv VARCHAR(255),
    adresa VARCHAR(255),
    postanski_broj VARCHAR(20),
    grad VARCHAR(100),
    company BIGINT REFERENCES public.company(id)
);

-- Nalog
CREATE TABLE IF NOT EXISTS public.nalog (
    id BIGINT PRIMARY KEY DEFAULT nextval('nalog_seq'),
    broj VARCHAR(50),
    datum DATE,
    kupac BIGINT REFERENCES public.kupac(id),
    zavrsen BOOLEAN,
    company BIGINT REFERENCES public.company(id)
);

-- Stavka
CREATE TABLE IF NOT EXISTS public.stavka (
    id BIGINT PRIMARY KEY DEFAULT nextval('stavka_seq'),
    nalog BIGINT REFERENCES public.nalog(id),
    sifra VARCHAR(50),
    artikl VARCHAR(255),
    kolicina DOUBLE PRECISION,
    jedinica VARCHAR(50),
    cijena DOUBLE PRECISION
);

-- App user
CREATE TABLE IF NOT EXISTS public.app_user (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(50),
    company BIGINT REFERENCES public.company(id)
);
