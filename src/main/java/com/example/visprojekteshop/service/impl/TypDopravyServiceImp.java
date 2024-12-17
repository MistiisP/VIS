package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.TypDopravyDto;
import com.example.visprojekteshop.service.TypDopravyService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

public class TypDopravyServiceImp implements TypDopravyService {
    private List<TypDopravyDto> typDopravyList = new ArrayList<>();

    @Override
    public TypDopravyDto getTypDopravyById(Long id) {
        for (TypDopravyDto typDopravyDto : typDopravyList) {
            if (typDopravyDto.getId().equals(id)) {
                return typDopravyDto;
            }
        }
        return null;
    }

    @Override
    public TypDopravyDto createTypDopravy(TypDopravyDto typDopravyDto) {
        typDopravyList.add(typDopravyDto);
        return typDopravyDto;
    }

    @Override
    public TypDopravyDto updateTypDopravy(TypDopravyDto typDopravyDto) {
        for (TypDopravyDto typDopravyDto1 : typDopravyList) {
            if (typDopravyDto1.getId().equals(typDopravyDto.getId())) {
                typDopravyDto1.setNazev(typDopravyDto.getNazev());
                typDopravyDto1.setPopis(typDopravyDto.getPopis());
                typDopravyDto1.setPoplatek(typDopravyDto.getPoplatek());
                typDopravyDto1.setVaha(typDopravyDto.getVaha());
                typDopravyDto1.setVelikost(typDopravyDto.getVelikost());
                return typDopravyDto1;
            }
        }
        return null;
    }

    @Override
    public List<TypDopravyDto> getAllTypDopravy() {
        return typDopravyList;
    }

    @Override
    public void deleteTypDopravy(Long id) {
        for (TypDopravyDto typDopravyDto : typDopravyList) {
            if (typDopravyDto.getId().equals(id)) {
                typDopravyList.remove(typDopravyDto);
                return;
            }
        }
    }
}
