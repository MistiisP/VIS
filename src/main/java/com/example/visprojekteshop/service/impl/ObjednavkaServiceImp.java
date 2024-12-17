package com.example.visprojekteshop.service.impl;

import com.example.visprojekteshop.service.ObjednavkaService;
import com.example.visprojekteshop.DTO.ObjednavkaDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ObjednavkaServiceImp implements ObjednavkaService {
    public List<ObjednavkaDto> objednavkaList = new ArrayList<>();

    public ObjednavkaServiceImp() {
        // Bezparametrický konstruktor
    }
    
    @Override
    public ObjednavkaDto getObjednavkaById(Long id) {
        // Použití Optional pro lepší práci s neexistujícími objekty
        return objednavkaList.stream()
                .filter(objednavka -> objednavka.getId().equals(id))  // Používáme equals pro objekty typu Long
                .findFirst()
                .orElse(null);  // Vrací null pokud objednávka neexistuje
    }

    @Override
    public ObjednavkaDto createObjednavka(ObjednavkaDto objednavkaDto) {
        objednavkaList.add(objednavkaDto);
        return objednavkaDto;
    }


    @Override
    public void deleteObjednavka(Long id) {  // Změna typu ID na Long
        boolean removed = objednavkaList.removeIf(objednavka -> objednavka.getId().equals(id));  // Používáme equals pro objekty typu Long
        if (!removed) {
            throw new IllegalArgumentException("Objednávka s ID " + id + " nebyla nalezena.");
        }
    }

    // Metoda pro získání všech objednávek
    @Override
    public List<ObjednavkaDto> getAllObjednavky() {
        return new ArrayList<>(objednavkaList);  // Vrací kopii seznamu
    }
}
