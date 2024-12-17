package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zalivka {
    private int id_zalivka;
    private String popis;
}
