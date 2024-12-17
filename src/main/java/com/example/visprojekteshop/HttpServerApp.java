package com.example.visprojekteshop;

import com.example.visprojekteshop.Controller.OsobaController;
import com.example.visprojekteshop.Controller.ProduktController;
import com.example.visprojekteshop.Controller.ZamestnanecController;
import com.example.visprojekteshop.service.impl.OsobaServiceImp;
import com.example.visprojekteshop.service.impl.ProduktServiceImp;
import com.example.visprojekteshop.service.impl.ZamestnanecServiceImp;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServerApp {

    public static void main(String[] args) throws IOException {
        DatabaseConnection.initializeDatabase();

        ZamestnanecServiceImp zamestnanecService = new ZamestnanecServiceImp();
        ZamestnanecController zamestnanecController = new ZamestnanecController(zamestnanecService);

        ProduktController produktController = new ProduktController(new ProduktServiceImp());

        OsobaServiceImp osobaService = new OsobaServiceImp();
        OsobaController osobaController = new OsobaController(osobaService);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new TemplateHandler());
        server.createContext("/api/zamestnanci", zamestnanecController);
        server.createContext("/api/osoby", osobaController);

        server.createContext("/api/produkty", produktController);

        server.createContext("/createOsoba", osobaController);
        server.createContext("/deleteOsoba", osobaController);

        server.setExecutor(null);
        server.start();
        System.out.println("HTTP server running at http://localhost:8080");

        DatabaseStructurePrinter.printDatabaseStructure();
    }


    static class TemplateHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            String templateName = handleTemplateRequest(path);


            String content = "File " + templateName + " not found.";
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("com/example/visprojekteshop/templates/" + templateName + ".html");

            if (inputStream != null) {
                try {

                    content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    content = "Error reading file: " + templateName;
                    e.printStackTrace();
                }
            }


            exchange.sendResponseHeaders(200, content.getBytes(StandardCharsets.UTF_8).length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(content.getBytes(StandardCharsets.UTF_8));
            }
        }

        private String handleTemplateRequest(String path) {
            if (path.equals("/")) {
                return "index.html";
            }
            return path.substring(1);
        }
    }
}