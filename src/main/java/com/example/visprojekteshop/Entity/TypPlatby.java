package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypPlatby {
    private Long id_typ_platby;
    private String nazev;
    private String popis;
    private int maxcena;
    private int poplatek;
}
