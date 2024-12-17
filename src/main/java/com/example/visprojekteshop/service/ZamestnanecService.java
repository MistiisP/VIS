package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.ZamestnanecDto;

import java.util.List;

public interface ZamestnanecService {
    ZamestnanecDto getZamestnanecById(Long id);
    ZamestnanecDto getZamestnanecByJmeno(String jmeno);
    ZamestnanecDto createZamestnanec(ZamestnanecDto zamestnanecDto);
    ZamestnanecDto updateZamestnanec(Long id, ZamestnanecDto zamestnanecDto);
    List<ZamestnanecDto> getAllZamestnanec();

    void deleteZamestnanec(Long id);
}
