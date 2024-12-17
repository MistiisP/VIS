package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.DTO.TypPlatbyDto;
import com.example.visprojekteshop.service.TypPlatbyService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class TypPlatbyServiceImp implements TypPlatbyService {
    private List<TypPlatbyDto> typPlatbyList = new ArrayList<>();

    @Override
    public TypPlatbyDto getTypPlatbyById(Long id) {
        // Používáme equals pro porovnání Long
        return typPlatbyList.stream()
                .filter(typPlatby -> typPlatby.getId().equals(id))
                .findFirst()
                .orElse(null);  // Pokud není nalezeno, vrátí null
    }

    @Override
    public TypPlatbyDto createTypPlatby(TypPlatbyDto typPlatbyDto) {
        // Kontrola povinnosti názvu
        if (typPlatbyDto == null || typPlatbyDto.getNazev() == null || typPlatbyDto.getNazev().isEmpty()) {
            throw new IllegalArgumentException("Název platby je povinný.");
        }
        typPlatbyList.add(typPlatbyDto);
        return typPlatbyDto;
    }

    @Override
    public TypPlatbyDto updateTypPlatby(TypPlatbyDto typPlatbyDto) {
        // Najdeme existující typ platby podle ID
        Optional<TypPlatbyDto> existingTyp = typPlatbyList.stream()
                .filter(t -> t.getId().equals(typPlatbyDto.getId())) // Používáme equals pro porovnání Long
                .findFirst();

        // Pokud existuje, aktualizujeme ho
        return existingTyp.map(typPlatby -> {
            typPlatby.setNazev(typPlatbyDto.getNazev());  // Aktualizace pouze názvu
            typPlatby.setPopis(typPlatbyDto.getPopis());
            typPlatby.setMaxcena(typPlatbyDto.getMaxcena());
            typPlatby.setPoplatek(typPlatbyDto.getPoplatek());
            return typPlatby;
        }).orElseThrow(() ->
                new IllegalArgumentException("Typ platby s ID " + typPlatbyDto.getId() + " neexistuje.")
        );
    }

    @Override
    public void deleteTypPlatby(Long id) {
        // Pokud položka existuje, odstraníme ji
        boolean removed = typPlatbyList.removeIf(typPlatby -> typPlatby.getId().equals(id));

        if (!removed) {
            throw new IllegalArgumentException("Typ platby s ID " + id + " nebyl nalezen.");
        }
    }

    // Nová metoda pro získání všech typů platby
    @Override
    public List<TypPlatbyDto> getAllTypPlatby() {
        return new ArrayList<>(typPlatbyList);  // Vrací kopii seznamu
    }
}
