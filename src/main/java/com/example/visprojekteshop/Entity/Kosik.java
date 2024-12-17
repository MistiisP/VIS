package com.example.visprojekteshop.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Kosik {
    private Long id;
    private Long produkt_id;
    private int pocet;

    public Kosik(Long id, Long produkt_id, int pocet) {
        this.id = id;
        this.produkt_id = produkt_id;
        this.pocet = pocet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdukt_id() {
        return produkt_id;
    }

    public void setProdukt_id(Long produkt_id) {
        this.produkt_id = produkt_id;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

}
