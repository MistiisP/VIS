package com.example.visprojekteshop.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slunce {
    private int id_slunce;
    private String popis;
}