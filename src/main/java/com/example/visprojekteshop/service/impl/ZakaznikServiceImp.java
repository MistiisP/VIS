package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.ZakaznikDto;
import com.example.visprojekteshop.service.ZakaznikService;

import java.util.ArrayList;
import java.util.List;
public class ZakaznikServiceImp implements ZakaznikService {

    private List<ZakaznikDto> zakaznici = new ArrayList<>();

    @Override
    public ZakaznikDto getZakaznikById(Long id) {
        return zakaznici.stream()
                .filter(zakaznik -> zakaznik.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Zakaznik with ID " + id + " not found"));
    }

    @Override
    public ZakaznikDto getZakaznikByJmeno(String jmeno) {
        return zakaznici.stream()
                .filter(zakaznik -> zakaznik.getOsoba_id() != null && zakaznik.getOsoba_id().toString().equalsIgnoreCase(jmeno))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Zakaznik with name " + jmeno + " not found"));
    }

    @Override
    public ZakaznikDto createZakaznik(ZakaznikDto zakaznikDto) {
        zakaznici.add(zakaznikDto);
        return zakaznikDto;
    }

    @Override
    public ZakaznikDto updateZakaznik(ZakaznikDto zakaznikDto) {
        ZakaznikDto existingZakaznik = getZakaznikById(zakaznikDto.getId());
        existingZakaznik.setOsoba_id(zakaznikDto.getOsoba_id());
        return existingZakaznik;
    }

    @Override
    public ZakaznikDto getZakaznikByAdresa(String adresa) {
        // Placeholder: Ověřte, zda DTO obsahuje adresu
        return zakaznici.stream()
                .filter(zakaznik -> zakaznik.getOsoba_id() != null) // Přidejte ověření pro adresu
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Zakaznik with address " + adresa + " not found"));
    }

    @Override
    public List<ZakaznikDto> getAllZakaznik() {
        return new ArrayList<>(zakaznici);
    }

    @Override
    public void deleteZakaznik(Long id) {
        ZakaznikDto zakaznik = getZakaznikById(id);
        zakaznici.remove(zakaznik);
    }
}
