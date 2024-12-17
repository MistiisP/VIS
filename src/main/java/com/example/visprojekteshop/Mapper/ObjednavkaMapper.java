package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Objednavka;
import com.example.visprojekteshop.DTO.ObjednavkaDto;

public interface ObjednavkaMapper {
    public static ObjednavkaDto maptoObjednavkaDto(Objednavka objednavka) {
        return new ObjednavkaDto(
                objednavka.getId_objednavka(),
                objednavka.getZakaznik_id(),
                objednavka.getDoprava_id(),
                objednavka.getPlatba_id(),
                objednavka.getDatum()
        );
    }

    public static Objednavka maptoObjednavka(ObjednavkaDto objednavkaDto) {
        return new Objednavka(
                objednavkaDto.getId(),
                objednavkaDto.getZakaznikId(),
                objednavkaDto.getDopravaId(),
                objednavkaDto.getPlatbaId(),
                objednavkaDto.getDatum()
        );
    }
}