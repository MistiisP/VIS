package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.ZalivkaDto;

public interface ZalivkaService {
    ZalivkaDto getZalivkaById(int id);
    ZalivkaDto createZalivka(ZalivkaDto zalivkaDto);
    ZalivkaDto updateZalivka(ZalivkaDto zalivkaDto);

    void deleteZalivka(int id);
}
