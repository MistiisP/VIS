package com.example.visprojekteshop.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OsobaDto {
    private Long id;
    private String jmeno;
    private String prijmeni;
    private String email;
    private int telefon;
    private String adresa;
    private String heslo;

}
