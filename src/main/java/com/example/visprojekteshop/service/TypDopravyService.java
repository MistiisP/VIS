package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.TypDopravyDto;
import java.util.List;

public interface TypDopravyService {
    TypDopravyDto getTypDopravyById(Long id);
    TypDopravyDto createTypDopravy(TypDopravyDto typDopravyDto);
    TypDopravyDto updateTypDopravy(TypDopravyDto typDopravyDto);
    List<TypDopravyDto> getAllTypDopravy();

    void deleteTypDopravy(Long id);
}
