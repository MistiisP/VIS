package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Zakaznik;
import com.example.visprojekteshop.DTO.ZakaznikDto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public interface ZakaznikMapper {
    public static ZakaznikDto maptoZakaznikDto(Zakaznik zakaznik) {
        return new ZakaznikDto(
                zakaznik.getId_zakaznik(),
                zakaznik.getOsoba_id()
        );
    }

    public static Zakaznik maptoZakaznik(ZakaznikDto zakaznikDto) {
        return new Zakaznik(
                zakaznikDto.getId(),
                zakaznikDto.getOsoba_id()
        );
    }
}