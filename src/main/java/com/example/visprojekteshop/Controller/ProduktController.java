package com.example.visprojekteshop.Controller;

import com.example.visprojekteshop.DTO.ProduktDto;
import com.example.visprojekteshop.service.impl.ProduktServiceImp;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ProduktController implements HttpHandler {
    private final ProduktServiceImp produktService;

    public ProduktController(ProduktServiceImp produktService) {
        this.produktService = produktService;
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            List<ProduktDto> produkte = produktService.getAllProdukte();
            StringBuilder response = new StringBuilder("[");
            for (ProduktDto dto : produkte) {
                response.append(String.format(
                        "{\"id_produkt\": %d, \"nazev\": \"%s\", \"popis\": \"%s\", \"cena\": %d, \"skladem\": %d, \"jedoprava\": %b, \"kategorie_id\": %d, \"slunce_id\": %d, \"zalivka_id\": %d, \"typ_id\": %d},",
                        dto.getId(),
                        dto.getNazev(),
                        dto.getPopis(),
                        dto.getCena(),
                        dto.getSkladem(),
                        dto.isJedoprava(),
                        dto.getKategorieId(),
                        dto.getSlunceId(),
                        dto.getZalivkaId(),
                        dto.getTypId()
                ));
            }
            if (response.length() > 1) {
                response.setLength(response.length() - 1); // Remove the last comma
            }
            response.append("]");

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.toString().getBytes(StandardCharsets.UTF_8));
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }


    private void handleGet(HttpExchange exchange) throws IOException {
        List<ProduktDto> produkte = produktService.getAllProdukte();
        StringBuilder response = new StringBuilder("[");
        for (ProduktDto dto : produkte) {
            response.append(String.format(
                    "{\"id_produkt\": %d, \"nazev\": \"%s\", \"popis\": \"%s\", \"cena\": %d, \"skladem\": %d, \"jedoprava\": %b, \"kategorie_id\": %d, \"slunce_id\": %d, \"zalivka_id\": %d, \"typ_id\": %d},",
                    dto.getId(),
                    dto.getNazev(),
                    dto.getPopis(),
                    dto.getCena(),
                    dto.getSkladem(),
                    dto.isJedoprava(),
                    dto.getKategorieId(),
                    dto.getSlunceId(),
                    dto.getZalivkaId(),
                    dto.getTypId()
            ));
        }
        if (response.length() > 1) {
            response.setLength(response.length() - 1); // Remove the last comma
        }
        response.append("]");

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String query = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        String[] params = query.split("&");
        ProduktDto produktDto = new ProduktDto();

        for (String param : params) {
            String[] keyValue = param.split("=");
            switch (keyValue[0]) {
                case "id_produkt":
                    produktDto.setId(Long.parseLong(keyValue[1]));
                    break;
                case "nazev":
                    produktDto.setNazev(keyValue[1]);
                    break;
                case "popis":
                    produktDto.setPopis(keyValue[1]);
                    break;
                case "cena":
                    produktDto.setCena(Integer.parseInt(keyValue[1]));
                    break;
                case "skladem":
                    produktDto.setSkladem(Integer.parseInt(keyValue[1]));
                    break;
                case "jedoprava":
                    produktDto.setJedoprava(Boolean.parseBoolean(keyValue[1]));
                    break;
                case "kategorie_id":
                    produktDto.setKategorieId(Integer.parseInt(keyValue[1]));
                    break;
                case "slunce_id":
                    produktDto.setSlunceId(Integer.parseInt(keyValue[1]));
                    break;
                case "zalivka_id":
                    produktDto.setZalivkaId(Integer.parseInt(keyValue[1]));
                    break;
                case "typ_id":
                    produktDto.setTypId(Integer.parseInt(keyValue[1]));
                    break;
            }
        }

        produktService.createProdukt(produktDto);
        String response = "Produkt byl vytvořen.";
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }

    private void handleSearch(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String name = query != null && query.startsWith("name=") ? query.substring(5) : "";
        List<ProduktDto> products = produktService.searchProducts(name);
        StringBuilder response = new StringBuilder("[");
        for (ProduktDto dto : products) {
            response.append(String.format(
                    "{\"id_produkt\": %d, \"nazev\": \"%s\", \"popis\": \"%s\", \"cena\": %d, \"skladem\": %d, \"jedoprava\": %b, \"kategorie_id\": %d, \"slunce_id\": %d, \"zalivka_id\": %d, \"typ_id\": %d},",
                    dto.getId(),
                    dto.getNazev(),
                    dto.getPopis(),
                    dto.getCena(),
                    dto.getSkladem(),
                    dto.isJedoprava(),
                    dto.getKategorieId(),
                    dto.getSlunceId(),
                    dto.getZalivkaId(),
                    dto.getTypId()
            ));
        }
        if (response.length() > 1) {
            response.setLength(response.length() - 1); // Remove the last comma
        }
        response.append("]");

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.toString().getBytes(StandardCharsets.UTF_8));
        }
    }
}