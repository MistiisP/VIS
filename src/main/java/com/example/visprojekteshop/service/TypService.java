package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.TypDto;

public interface TypService {
    TypDto getTypById(int id);
    TypDto createTyp(TypDto typDto);
    TypDto updateTyp(TypDto typDto);

    void deleteTyp(int id);
}
