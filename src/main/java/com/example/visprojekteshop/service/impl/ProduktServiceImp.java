package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.ProduktDto;
import com.example.visprojekteshop.Entity.Produkt;
import com.example.visprojekteshop.Mapper.ProduktMapper;
import com.example.visprojekteshop.Repository.ProduktRepository;
import com.example.visprojekteshop.service.ProduktService;

import java.util.List;
import java.util.stream.Collectors;

public class ProduktServiceImp implements ProduktService {
    private final ProduktRepository produktRepository;

    public ProduktServiceImp() {
        this.produktRepository = new ProduktRepository();
    }

    @Override
    public ProduktDto createProdukt(ProduktDto produktDto) {
        Produkt produkt = ProduktMapper.maptoProdukt(produktDto);
        produktRepository.save(produkt);
        return produktDto;
    }

    @Override
    public List<ProduktDto> getAllProdukte() {
        List<Produkt> produkty = produktRepository.findAll();
        return produkty.stream()
                .map(ProduktMapper::maptoProduktDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduktDto> searchProducts(String name) {
        List<Produkt> produkty = produktRepository.findByName(name);
        return produkty.stream()
                .map(ProduktMapper::maptoProduktDto)
                .collect(Collectors.toList());
    }
}