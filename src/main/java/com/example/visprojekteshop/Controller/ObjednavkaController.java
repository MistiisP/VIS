package com.example.visprojekteshop.Controller;

import com.example.visprojekteshop.DTO.ObjednavkaDto;
import com.example.visprojekteshop.service.ObjednavkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objednavky")
public class ObjednavkaController {

    private final ObjednavkaService objednavkaService;

    // Injektování služby do controlleru
    @Autowired
    public ObjednavkaController(ObjednavkaService objednavkaService) {
        this.objednavkaService = objednavkaService;
    }

    // API: Získání všech objednávek
    @GetMapping
    public ResponseEntity<List<ObjednavkaDto>> getAllOrders() {
        List<ObjednavkaDto> objednavky = objednavkaService.getAllObjednavky(); // Volání služby pro získání seznamu objednávek
        return ResponseEntity.ok(objednavky);
    }

    // API: Získání konkrétní objednávky podle ID
    @GetMapping("/{id}")
    public ResponseEntity<ObjednavkaDto> getOrderById(@PathVariable Long id) {
        ObjednavkaDto objednavka = objednavkaService.getObjednavkaById(id); // Volání služby pro získání konkrétní objednávky
        return ResponseEntity.ok(objednavka);
    }

    // API: Vytvoření nové objednávky
    @PostMapping
    public ResponseEntity<ObjednavkaDto> createOrder(@RequestBody ObjednavkaDto objednavkaDto) {
        ObjednavkaDto savedObjednavka = objednavkaService.createObjednavka(objednavkaDto); // Volání služby pro vytvoření objednávky
        return new ResponseEntity<>(savedObjednavka, HttpStatus.CREATED);
    }


    // API: Smazání objednávky
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        objednavkaService.deleteObjednavka(id); // Volání služby pro smazání objednávky
        return ResponseEntity.ok("Objednávka byla úspěšně smazána");
    }
}
