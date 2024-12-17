package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Typ {
    private int id_typ;
    private String nazev;
    private String popis;
}