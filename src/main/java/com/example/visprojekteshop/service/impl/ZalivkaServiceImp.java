package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.ZalivkaDto;
import com.example.visprojekteshop.service.ZalivkaService;
import java.util.List;
import java.util.ArrayList;

public class ZalivkaServiceImp implements ZalivkaService {
    private List<ZalivkaDto> zalivkaList = new ArrayList<>();

    @Override
    public ZalivkaDto getZalivkaById(int id) {
        return zalivkaList.stream()
                .filter(zalivka -> zalivka.getId_zalivka() == id) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
    }

    @Override
    public ZalivkaDto createZalivka(ZalivkaDto zalivkaDto) {
        zalivkaList.add(zalivkaDto);
        return zalivkaDto;
    }

    @Override
    public ZalivkaDto updateZalivka(ZalivkaDto zalivkaDto) {
        ZalivkaDto zalivka = zalivkaList.stream()
                .filter(z -> z.getId_zalivka() == zalivkaDto.getId_zalivka()) // Použití == pro primitivní typ
                .findFirst()
                .orElse(null);
        if (zalivka != null) {
            zalivka.setPopis(zalivkaDto.getPopis()); // Aktualizace pouze popisu
        }
        return zalivka;
    }

    @Override
    public void deleteZalivka(int id) {
        zalivkaList.removeIf(zalivka -> zalivka.getId_zalivka() == id); // Použití == pro primitivní typ
    }
}
