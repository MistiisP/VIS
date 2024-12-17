package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Kategorie;
import com.example.visprojekteshop.DTO.KategorieDto;
public interface KategorieMapper {
    public static KategorieDto maptoKategorieDto(Kategorie kategorie) {
        return new KategorieDto(
                kategorie.getId(),
                kategorie.getNazev(),
                kategorie.getPopis()
        );
    }

    public static Kategorie maptoKategorie(KategorieDto kategorieDto) {
        return new Kategorie(
                kategorieDto.getId(),
                kategorieDto.getNazev(),
                kategorieDto.getPopis()
        );
    }
}
