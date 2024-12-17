package com.example.visprojekteshop.Controller;

import com.example.visprojekteshop.DTO.ZamestnanecDto;
import com.example.visprojekteshop.service.impl.ZamestnanecServiceImp;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ZamestnanecController implements HttpHandler {
    private final ZamestnanecServiceImp zamestnanecService;

    public ZamestnanecController(ZamestnanecServiceImp zamestnanecService) {
        this.zamestnanecService = zamestnanecService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            List<ZamestnanecDto> zamestnanci = zamestnanecService.getAllZamestnanci();
            StringBuilder response = new StringBuilder("[");
            for (ZamestnanecDto dto : zamestnanci) {
                response.append(String.format(
                        "{\"id_zamestnanec\": %d, \"osoba_id\": %d, \"plat\": %d, \"pracovni_pozice\": \"%s\", \"pracovni_telefon\": %d},",
                        dto.getId_zamestnanec(),
                        dto.getOsoba_id(),
                        dto.getPlat(),
                        dto.getPracovni_pozice(),
                        dto.getPracovni_telefon()
                ));
            }
            if (response.length() > 1) {
                response.setLength(response.length() - 1); // Remove the last comma
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
}
