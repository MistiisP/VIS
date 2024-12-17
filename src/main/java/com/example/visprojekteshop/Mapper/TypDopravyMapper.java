package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.TypDopravy;
import com.example.visprojekteshop.DTO.TypDopravyDto;
public interface TypDopravyMapper {
    public static TypDopravyDto maptoTypDopravyDto(TypDopravy typDopravy) {
        return new TypDopravyDto(
                typDopravy.getId_typ_dopravy(),
                typDopravy.getNazev(),
                typDopravy.getPopis(),
                typDopravy.getPoplatek(),
                typDopravy.getVaha(),
                typDopravy.getVelikost()
        );
    }

    public static TypDopravy maptoTypDopravy(TypDopravyDto typDopravyDto) {
        return new TypDopravy(
                typDopravyDto.getId(),
                typDopravyDto.getNazev(),
                typDopravyDto.getPopis(),
                typDopravyDto.getPoplatek(),
                typDopravyDto.getVaha(),
                typDopravyDto.getVelikost()
        );
    }
}
