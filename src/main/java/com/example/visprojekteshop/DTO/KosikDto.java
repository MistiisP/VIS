package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KosikDto {
    private Long id;
    private Long produkt_id;
    private int pocet;
}
