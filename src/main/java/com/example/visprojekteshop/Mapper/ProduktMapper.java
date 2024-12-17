package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Produkt;
import com.example.visprojekteshop.DTO.ProduktDto;

public interface ProduktMapper {
    public static ProduktDto maptoProduktDto(Produkt produkt) {
        return new ProduktDto(
                produkt.getId_produkt(),
                produkt.getNazev(),
                produkt.getPopis(),
                produkt.getCena(),
                produkt.getSkladem(),
                produkt.isJedoprava(),
                produkt.getKategorie_id(),
                produkt.getSlunce_id(),
                produkt.getZalivka_id(),
                produkt.getTyp_id()
        );
    }

    public static Produkt maptoProdukt(ProduktDto produktDto) {
        return new Produkt(
                produktDto.getId(),
                produktDto.getNazev(),
                produktDto.getPopis(),
                produktDto.getCena(),
                produktDto.getSkladem(),
                produktDto.isJedoprava(),
                produktDto.getKategorieId(),
                produktDto.getSlunceId(),
                produktDto.getZalivkaId(),
                produktDto.getTypId()
        );
    }
}
