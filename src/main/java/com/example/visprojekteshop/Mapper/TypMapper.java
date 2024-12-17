package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Typ;
import com.example.visprojekteshop.DTO.TypDto;
public interface TypMapper {
    public static TypDto maptoTypDto(Typ typ) {
        return new TypDto(
                typ.getId_typ(),
                typ.getNazev(),
                typ.getPopis()
        );
    }

    public static Typ maptoTyp(TypDto typDto) {
        return new Typ(
                typDto.getId_typ(),
                typDto.getNazev(),
                typDto.getPopis()
        );
    }
}
