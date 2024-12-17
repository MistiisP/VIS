package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.OsobaDto;
import com.example.visprojekteshop.Entity.Osoba;
import com.example.visprojekteshop.Mapper.OsobaMapper;
import com.example.visprojekteshop.Repository.OsobaRepository;
import com.example.visprojekteshop.service.OsobaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OsobaServiceImp implements OsobaService {
    private final OsobaRepository osobaRepository;

    public OsobaServiceImp() {
        this.osobaRepository = new OsobaRepository();
    }

    @Override
    public OsobaDto createOsoba(OsobaDto osobaDto) {
        Osoba osoba = OsobaMapper.maptoOsoba(osobaDto);
        osobaRepository.save(osoba);
        return osobaDto;
    }

    @Override
    public OsobaDto getOsobaById(Long id) {
        Osoba osoba = osobaRepository.findById(id);
        return OsobaMapper.maptoOsobaDto(osoba);
    }

    @Override
    public void deleteOsoba(Long id) {
        osobaRepository.deleteById(id);
    }

    @Override
    public List<OsobaDto> getAllOsoby() {
        List<Osoba> osoby = osobaRepository.findAll();
        return osoby.stream()
                .map(OsobaMapper::maptoOsobaDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OsobaDto> zobrazHtml() {
        return getAllOsoby();
    }

}