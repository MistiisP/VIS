INSERT INTO kategorie (id, nazev, popis) VALUES
(1, 'Květiny', 'Různé druhy květin pro domácí i venkovní použití'),
(2, 'Zelenina', 'Rostliny k pěstování zeleniny na zahradě'),
(3, 'Bylinky', 'Aromatické bylinky pro vaření nebo léčbu');

INSERT INTO typ (id, nazev, popis) VALUES
(1, 'Květináč', 'Rostlina vhodná k umístění do květináče'),
(2, 'Zahradní', 'Vhodné k sázení přímo na zahradu'),
(3, 'Hydroponické', 'Pěstování bez půdy s vodním roztokem živin');

INSERT INTO slunce (id, popis) VALUES
(1, 'Plné slunce - ideální pro rostliny vyžadující intenzivní světlo'),
(2, 'Částečný stín - rostliny, které zvládnou stín během části dne'),
(3, 'Stín - vhodné pro málo osvětlené prostředí');

INSERT INTO zalivka (id, popis) VALUES
(1, 'Nízká - zalévat jednou týdně nebo méně'),
(2, 'Střední - zalévat jednou za pár dní'),
(3, 'Vysoká - zalévat denně nebo častěji');

INSERT INTO typ_dopravy_objednavky (id, nazev, popis, poplatek, vaha, velikost) VALUES
(1, 'Kurýr', 'Rychlé doručení kurýrem na adresu', 150, 20, 50),
(2, 'Pošta', 'Standardní doručení prostřednictvím pošty', 80, 10, 30),
(3, 'Osobní odběr', 'Možnost vyzvednutí na pobočce zdarma', 0, 0, 0);

INSERT INTO typ_platby_objednavky (id, nazev, popis, maxcena, poplatek) VALUES
(1, 'Hotově', 'Platba v hotovosti při převzetí', 10000, 0),
(2, 'Karta', 'Platba kartou online nebo na místě', 50000, 20),
(3, 'Převod', 'Bankovní převod před doručením', 100000, 10);

INSERT INTO osoba (id, jmeno, prijmeni, email, telefon, adresa, heslo) VALUES
(1, 'Jan', 'Novák', 'jan.novak@example.com', '123456789', 'Ulice 1, Praha', 'heslo123'),
(2, 'Petra', 'Malá', 'petra.mala@example.com', '987654321', 'Ulice 2, Brno', 'tajneheslo'),
(3, 'Karel', 'Velký', 'karel.velky@example.com', '111222333', 'Ulice 3, Ostrava', 'karel2024');

INSERT INTO zakaznik (id, osoba_id) VALUES
(1, 1),  -- Jan Novák
(2, 2);  -- Petra Malá

INSERT INTO zamestnanec (id, osoba_id, plat, pracovni_pozice, pracovni_telefon) VALUES
(1, 3, 45000, 'Manažer prodeje', '555123456');  -- Karel Velký

INSERT INTO produkt (id, nazev, popis, cena, skladem, jedoprava, kategorie_id, slunce_id, zalivka_id, typ_id) VALUES
(1, 'Růže', 'Krásná červená růže', 100, 50, TRUE, 1, 1, 2, 1),
(2, 'Rajče', 'Rajče keřové pro zahradní pěstování', 50, 100, FALSE, 2, 2, 3, 2),
(3, 'Bazalka', 'Aromatická bylina vhodná do jídel', 30, 200, TRUE, 3, 3, 1, 1);

INSERT INTO objednavka (id, zakaznik_id, doprava_id, platba_id, datum) VALUES
(1, 1, 1, 2, '2024-11-01'),  -- Objednávka Jana Nováka
(2, 2, 2, 3, '2024-11-02');  -- Objednávka Petry Malé
