package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Zamestnanec;
import com.example.visprojekteshop.DTO.ZamestnanecDto;

public interface ZamestnanecMapper {
    public static ZamestnanecDto maptoZamestnanecDto(Zamestnanec zamestnanec) {
        return new ZamestnanecDto(
                zamestnanec.getId_zamestnanec(),
                zamestnanec.getOsoba_id(),
                zamestnanec.getPlat(),
                zamestnanec.getPracovni_pozice(),
                zamestnanec.getPracovni_telefon()
        );
    }

    public static Zamestnanec maptoZamestnanec(ZamestnanecDto zamestnanecDto) {
        return new Zamestnanec(
                zamestnanecDto.getId_zamestnanec(),
                zamestnanecDto.getOsoba_id(),
                zamestnanecDto.getPlat(),
                zamestnanecDto.getPracovni_pozice(),
                zamestnanecDto.getPracovni_telefon()
        );
    }
}
