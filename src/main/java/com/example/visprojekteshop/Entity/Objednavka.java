package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Objednavka {
    private Long id_objednavka;
    private Long zakaznik_id;
    private Long doprava_id;
    private Long platba_id;
    private Date datum;

    public Objednavka(Long id_objednavka, Long zakaznik_id, Long doprava_id, Long platba_id, Date datum) {
        this.id_objednavka = id_objednavka;
        this.zakaznik_id = zakaznik_id;
        this.doprava_id = doprava_id;
        this.platba_id = platba_id;
        this.datum = datum;
    }

    public Long getId_objednavka() {
        return id_objednavka;
    }

    public void setId_objednavka(Long id_objednavka) {
        this.id_objednavka = id_objednavka;
    }

    public Long getZakaznik_id() {
        return zakaznik_id;
    }

    public void setZakaznik_id(Long zakaznik_id) {
        this.zakaznik_id = zakaznik_id;
    }

    public Long getDoprava_id() {
        return doprava_id;
    }

    public void setDoprava_id(Long doprava_id) {
        this.doprava_id = doprava_id;
    }

    public Long getPlatba_id() {
        return platba_id;
    }

    public void setPlatba_id(Long platba_id) {
        this.platba_id = platba_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
