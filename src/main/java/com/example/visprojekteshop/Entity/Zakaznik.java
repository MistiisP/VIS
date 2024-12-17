package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zakaznik{
    private Long id_zakaznik;
    private Long osoba_id;
}
