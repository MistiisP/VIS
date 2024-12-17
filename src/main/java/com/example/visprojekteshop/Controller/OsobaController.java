package com.example.visprojekteshop.Controller;

import com.example.visprojekteshop.DTO.OsobaDto;
import com.example.visprojekteshop.service.impl.OsobaServiceImp;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OsobaController implements HttpHandler {
    private final OsobaServiceImp osobaService;

    public OsobaController(OsobaServiceImp osobaService) {
        this.osobaService = osobaService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            List<OsobaDto> osoby = osobaService.getAllOsoby();

            StringBuilder response = new StringBuilder("[");
            for (OsobaDto dto : osoby) {
                response.append(String.format(
                        "{\"id\": %d, \"jmeno\": \"%s\", \"prijmeni\": \"%s\", \"telefon\": \"%s\", \"adresa\": \"%s\"},",
                        dto.getId(),
                        dto.getJmeno(),
                        dto.getPrijmeni(),
                        dto.getTelefon(),
                        dto.getAdresa()
                ));
            }
            if (response.length() > 1) {
                response.setLength(response.length() - 1); // Odloučit poslední čárku
            }

            response.append("]");

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.toString().getBytes());
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }

    public void deleteOsoba(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String query = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            String[] params = query.split("&");
            Long personId = null;

            for (String param : params) {
                String[] keyValue = param.split("=");
                if ("personId".equals(keyValue[0])) {
                    personId = Long.parseLong(keyValue[1]);
                }
            }

            if (personId != null) {
                osobaService.deleteOsoba(personId);
                String response = "Osoba s ID " + personId + " byla smazána.";
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } else {
                exchange.sendResponseHeaders(400, -1); // Bad Request
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }


    public void createOsoba(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String query = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            String[] params = query.split("&");
            OsobaDto osobaDto = new OsobaDto();

            for (String param : params) {
                String[] keyValue = param.split("=");
                switch (keyValue[0]) {
                    case "id":
                        osobaDto.setId(Long.parseLong(keyValue[1]));
                        break;
                    case "jmeno":
                        osobaDto.setJmeno(keyValue[1]);
                        break;
                    case "prijmeni":
                        osobaDto.setPrijmeni(keyValue[1]);
                        break;
                    case "email":
                        osobaDto.setEmail(keyValue[1]);
                        break;
                    case "telefon":
                        osobaDto.setTelefon(Integer.parseInt(keyValue[1]));
                        break;
                    case "adresa":
                        osobaDto.setAdresa(keyValue[1]);
                        break;
                    case "heslo":
                        osobaDto.setHeslo(keyValue[1]);
                        break;
                }
            }

            osobaService.createOsoba(osobaDto);
            String response = "Osoba byla vytvořena.";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }

}
