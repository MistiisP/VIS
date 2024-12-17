package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.SlunceDto;
import com.example.visprojekteshop.service.SlunceService;
import java.util.List;
import java.util.ArrayList;

public class SlunceServiceImp implements SlunceService {
    private List<SlunceDto> slunceList = new ArrayList<>();

    @Override
    public SlunceDto getSlunceById(int id) {
        return slunceList.stream()
                .filter(slunce -> slunce.getId() == id) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
    }

    @Override
    public SlunceDto createSlunce(SlunceDto slunceDto) {
        slunceList.add(slunceDto);
        return slunceDto;
    }

    @Override
    public SlunceDto updateSlunce(SlunceDto slunceDto) {
        SlunceDto slunce = slunceList.stream()
                .filter(s -> s.getId() == slunceDto.getId()) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
        if (slunce != null) {
            slunce.setPopis(slunceDto.getPopis()); // Aktualizace pouze popisu
        }
        return slunce;
    }

    @Override
    public void deleteSlunce(int id) {
        slunceList.removeIf(slunce -> slunce.getId() == id); // Použití == pro primitivní typ
    }
}
