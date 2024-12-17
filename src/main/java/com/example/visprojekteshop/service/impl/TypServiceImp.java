package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.TypDto;
import com.example.visprojekteshop.service.TypService;
import java.util.List;
import java.util.ArrayList;

public class TypServiceImp implements TypService {
    private List<TypDto> typList = new ArrayList<>();

    @Override
    public TypDto getTypById(int id) {
        return typList.stream()
                .filter(typ -> typ.getId_typ() == id) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
    }

    @Override
    public TypDto createTyp(TypDto typDto) {
        typList.add(typDto);
        return typDto;
    }

    @Override
    public TypDto updateTyp(TypDto typDto) {
        TypDto typ = typList.stream()
                .filter(t -> t.getId_typ() == typDto.getId_typ()) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
        if (typ != null) {
            typ.setNazev(typDto.getNazev()); // Aktualizace pouze názvu
        }
        return typ;
    }

    @Override
    public void deleteTyp(int id) {
        typList.removeIf(typ -> typ.getId_typ() == id); // Použití == pro primitivní typ
    }
}
