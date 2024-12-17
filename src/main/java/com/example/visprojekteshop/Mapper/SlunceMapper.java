package com.example.visprojekteshop.Mapper;

import com.example.visprojekteshop.Entity.Slunce;
import com.example.visprojekteshop.DTO.SlunceDto;
public interface SlunceMapper {
    public static SlunceDto maptoSlunceDto(Slunce slunce) {
        return new SlunceDto(
                slunce.getId_slunce(),
                slunce.getPopis()
        );
    }

    public static Slunce maptoSlunce(SlunceDto slunceDto) {
        return new Slunce(
                slunceDto.getId(),
                slunceDto.getPopis()
        );
    }

}
