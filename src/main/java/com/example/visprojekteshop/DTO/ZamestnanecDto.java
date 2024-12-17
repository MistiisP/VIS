package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZamestnanecDto {
    private Long id_zamestnanec;
    private Long osoba_id;
    private int plat;
    private String pracovni_pozice;
    private int pracovni_telefon;
}

