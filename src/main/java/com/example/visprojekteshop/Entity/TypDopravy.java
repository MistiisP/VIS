package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypDopravy {
    private Long id_typ_dopravy;
    private String nazev;
    private String popis;
    private int poplatek;
    private int vaha;
    private int velikost;
}
