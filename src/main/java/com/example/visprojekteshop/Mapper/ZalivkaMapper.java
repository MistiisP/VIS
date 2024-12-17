package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Zalivka;
import com.example.visprojekteshop.DTO.ZalivkaDto;
public interface ZalivkaMapper {
    public static ZalivkaDto maptoZalivkaDto(Zalivka zalivka) {
        return new ZalivkaDto(
                zalivka.getId_zalivka(),
                zalivka.getPopis()
        );
    }

    public static Zalivka maptoZalivka(ZalivkaDto zalivkaDto) {
        return new Zalivka(
                zalivkaDto.getId_zalivka(),
                zalivkaDto.getPopis()
        );
    }
}
