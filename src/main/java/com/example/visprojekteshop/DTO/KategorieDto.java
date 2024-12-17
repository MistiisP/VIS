package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KategorieDto {
    private int id;
    private String nazev;
    private String popis;
}
