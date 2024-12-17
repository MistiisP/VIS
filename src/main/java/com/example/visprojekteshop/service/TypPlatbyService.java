package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.TypPlatbyDto;
import java.util.List;

public interface TypPlatbyService {
    TypPlatbyDto getTypPlatbyById(Long id);
    TypPlatbyDto createTypPlatby(TypPlatbyDto typPlatbyDto);
    TypPlatbyDto updateTypPlatby(TypPlatbyDto typPlatbyDto);
    List<TypPlatbyDto> getAllTypPlatby();

    void deleteTypPlatby(Long id);
}
