-- Tabulka Kategorie
CREATE TABLE IF NOT EXISTS kategorie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT
);

-- Tabulka Typ
CREATE TABLE IF NOT EXISTS typ (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT
);

-- Tabulka Slunce
CREATE TABLE IF NOT EXISTS slunce (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    popis TEXT
);

-- Tabulka Zalivka
CREATE TABLE IF NOT EXISTS zalivka (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    popis TEXT
);

-- Tabulka Osoba
CREATE TABLE IF NOT EXISTS osoba (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    jmeno VARCHAR(100) NOT NULL,
    prijmeni VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE, -- Unikátní email
    telefon VARCHAR(20) NOT NULL, -- Telefon jako VARCHAR pro různé formáty
    adresa VARCHAR(100) NOT NULL,
    heslo VARCHAR(100) NOT NULL
);

-- Tabulka TypDopravyObjednavky
CREATE TABLE IF NOT EXISTS typ_dopravy_objednavky (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    poplatek INT NOT NULL,
    vaha INT NOT NULL,
    velikost INT NOT NULL
);

-- Tabulka TypPlatbyObjednavky
CREATE TABLE IF NOT EXISTS typ_platby_objednavky (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    maxcena INT NOT NULL,
    poplatek INT NOT NULL
);

-- Tabulka Zakaznik
CREATE TABLE IF NOT EXISTS zakaznik (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    osoba_id BIGINT NOT NULL,
    CONSTRAINT fk_zakaznik_osoba FOREIGN KEY (osoba_id) REFERENCES osoba (id)
);

-- Tabulka Zamestnanec
CREATE TABLE IF NOT EXISTS zamestnanec (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    osoba_id BIGINT NOT NULL,
    plat INT NOT NULL,
    pracovni_pozice VARCHAR(100) NOT NULL,
    pracovni_telefon VARCHAR(20) NOT NULL, -- Telefon jako VARCHAR
    CONSTRAINT fk_zamestnanec_osoba FOREIGN KEY (osoba_id) REFERENCES osoba (id)
);

-- Tabulka Produkt
CREATE TABLE IF NOT EXISTS produkt (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(100) NOT NULL,
    popis TEXT,
    cena INT NOT NULL,
    skladem INT NOT NULL,
    jedoprava BOOLEAN NOT NULL,
    kategorie_id BIGINT NOT NULL,
    slunce_id BIGINT NOT NULL,
    zalivka_id BIGINT NOT NULL,
    typ_id BIGINT NOT NULL,
    CONSTRAINT fk_produkt_kategorie FOREIGN KEY (kategorie_id) REFERENCES kategorie (id),
    CONSTRAINT fk_produkt_slunce FOREIGN KEY (slunce_id) REFERENCES slunce (id),
    CONSTRAINT fk_produkt_zalivka FOREIGN KEY (zalivka_id) REFERENCES zalivka (id),
    CONSTRAINT fk_produkt_typ FOREIGN KEY (typ_id) REFERENCES typ (id)
);

-- Tabulka Objednavka
CREATE TABLE IF NOT EXISTS objednavka (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    zakaznik_id BIGINT NOT NULL,
    doprava_id BIGINT NOT NULL,
    platba_id BIGINT NOT NULL,
    datum DATE NOT NULL,
    CONSTRAINT fk_objednavka_zakaznik FOREIGN KEY (zakaznik_id) REFERENCES zakaznik (id),
    CONSTRAINT fk_objednavka_doprava FOREIGN KEY (doprava_id) REFERENCES typ_dopravy_objednavky (id),
    CONSTRAINT fk_objednavka_platba FOREIGN KEY (platba_id) REFERENCES typ_platby_objednavky (id)
);
