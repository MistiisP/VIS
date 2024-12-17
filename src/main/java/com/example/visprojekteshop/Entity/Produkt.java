package com.example.visprojekteshop.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produkt {
        private Long id_produkt;
        private String nazev;
        private String popis;
        private int cena;
        private int skladem;
        private boolean jedoprava;
        private int kategorie_id;
        private int slunce_id;
        private int zalivka_id;
        private int typ_id;
}

