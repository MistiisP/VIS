package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduktDto {
    private Long id;
    private String nazev;
    private String popis;
    private int cena;
    private int skladem;
    private boolean jedoprava;
    private int kategorieId;
    private int slunceId;
    private int zalivkaId;
    private int typId;
}