package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Osoba;
import com.example.visprojekteshop.DTO.OsobaDto;
import lombok.*;
public interface OsobaMapper {
    // Mapování z entity na DTO
    public static OsobaDto maptoOsobaDto(Osoba osoba) {
        return new OsobaDto(
                osoba.getId(),
                osoba.getJmeno(),
                osoba.getPrijmeni(),
                osoba.getEmail(),
                osoba.getTelefon(),
                osoba.getAdresa(),
                osoba.getHeslo()
        );
    }

    // Mapování z DTO na entitu
    public static Osoba maptoOsoba(OsobaDto osobaDto) {
        return new Osoba(
                osobaDto.getId(),
                osobaDto.getJmeno(),
                osobaDto.getPrijmeni(),
                osobaDto.getEmail(),
                osobaDto.getTelefon(),
                osobaDto.getAdresa(),
                osobaDto.getHeslo()
        );
    }
}