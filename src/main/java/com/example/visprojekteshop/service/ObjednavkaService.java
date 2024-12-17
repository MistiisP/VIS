package com.example.visprojekteshop.service;

import com.example.visprojekteshop.DTO.ObjednavkaDto;
import java.util.List;

public interface ObjednavkaService {
    ObjednavkaDto getObjednavkaById(Long id);
    ObjednavkaDto createObjednavka(ObjednavkaDto objednavkaDto);
    List<ObjednavkaDto> getAllObjednavky();

    void deleteObjednavka(Long id);
}
