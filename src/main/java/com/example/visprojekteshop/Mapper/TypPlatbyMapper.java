package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.TypPlatby;
import com.example.visprojekteshop.DTO.TypPlatbyDto;
public interface TypPlatbyMapper {
    public static TypPlatbyDto maptoTypPlatbyDto(TypPlatby typPlatby) {
        return new TypPlatbyDto(
                typPlatby.getId_typ_platby(),
                typPlatby.getNazev(),
                typPlatby.getPopis(),
                typPlatby.getMaxcena(),
                typPlatby.getPoplatek()
        );
    }

    public static TypPlatby maptoTypPlatby(TypPlatbyDto typPlatbyDto) {
        return new TypPlatby(
                typPlatbyDto.getId(),
                typPlatbyDto.getNazev(),
                typPlatbyDto.getPopis(),
                typPlatbyDto.getMaxcena(),
                typPlatbyDto.getPoplatek()
        );
    }
}
