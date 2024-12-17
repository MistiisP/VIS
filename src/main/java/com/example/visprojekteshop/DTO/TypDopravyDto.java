package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypDopravyDto {
    private Long id;
    private String nazev;
    private String popis;
    private int poplatek;
    private int vaha;
    private int velikost;
}
