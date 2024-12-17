package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.ZamestnanecDto;
import com.example.visprojekteshop.Entity.Zamestnanec;
import com.example.visprojekteshop.Mapper.ZamestnanecMapper;
import com.example.visprojekteshop.Repository.ZamestnanecRepository;
import com.example.visprojekteshop.service.ZamestnanecService;

import java.util.List;
import java.util.stream.Collectors;

public class ZamestnanecServiceImp implements ZamestnanecService {
    private final ZamestnanecRepository zamestnanecRepository;

    public ZamestnanecServiceImp() {
        this.zamestnanecRepository = new ZamestnanecRepository();
    }

    @Override
    public List<ZamestnanecDto> getAllZamestnanci() {
        List<Zamestnanec> zamestnanci = zamestnanecRepository.findAll();
        return zamestnanci.stream()
                .map(ZamestnanecMapper::maptoZamestnanecDto)
                .collect(Collectors.toList());
    }

    @Override
    public ZamestnanecDto getZamestnanecById(Long id) {
        Zamestnanec zamestnanec = zamestnanecRepository.findById(id);
        return ZamestnanecMapper.maptoZamestnanecDto(zamestnanec);
    }

    @Override
    public void saveZamestnanec(ZamestnanecDto zamestnanecDto) {
        Zamestnanec zamestnanec = ZamestnanecMapper.maptoZamestnanec(zamestnanecDto);
        zamestnanecRepository.save(zamestnanec);
    }

    @Override
    public void deleteZamestnanecById(Long id) {
        zamestnanecRepository.deleteById(id);
    }
}