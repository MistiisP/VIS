package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.ZakaznikDto;

import java.util.List;


public interface ZakaznikService {
    ZakaznikDto getZakaznikById(Long id);
    ZakaznikDto getZakaznikByJmeno(String jmeno);
    ZakaznikDto createZakaznik(ZakaznikDto zakaznikDto);
    ZakaznikDto updateZakaznik(ZakaznikDto zakaznikDto);
    ZakaznikDto getZakaznikByAdresa(String adresa);
    List<ZakaznikDto> getAllZakaznik();

    void deleteZakaznik(Long id);
}
