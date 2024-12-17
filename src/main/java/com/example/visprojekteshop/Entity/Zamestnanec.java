package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zamestnanec")
public class Zamestnanec{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_zamestnanec;
    private Long osoba_id;
    private int plat;
    private String pracovni_pozice;
    private int pracovni_telefon;
}
