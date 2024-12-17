package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.SlunceDto;

public interface SlunceService {
    SlunceDto getSlunceById(int id);
    SlunceDto createSlunce(SlunceDto slunceDto);
    SlunceDto updateSlunce(SlunceDto slunceDto);

    void deleteSlunce(int id);
}
