package com.example.visprojekteshop.service;

        import com.example.visprojekteshop.DTO.OsobaDto;
        import java.time.LocalDate;
        import java.util.List;

public interface OsobaService {
    OsobaDto createOsoba(OsobaDto osobaDto);

    OsobaDto getOsobaById(Long id);


    void deleteOsoba(Long id);

    List<OsobaDto> getAllOsoby();

    List<OsobaDto> zobrazHtml();

}
