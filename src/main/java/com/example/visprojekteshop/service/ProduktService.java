package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.ProduktDto;

import java.util.List;

public interface ProduktService {
    ProduktDto createProdukt(ProduktDto produktDto);
    List<ProduktDto> getAllProdukte();
    List<ProduktDto> searchProducts(String name);
}