package com.example.visprojekteshop;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:moje_databaze.db";

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String initSql = loadSQLFromResources("com/example/visprojekteshop/database/init.sql");
            executeMultipleStatements(stmt, initSql);

            ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) AS count FROM osoba");
            if (resultSet.next() && resultSet.getInt("count") == 0) {
                String insertSql = loadSQLFromResources("com/example/visprojekteshop/database/insert.sql");
                executeMultipleStatements(stmt, insertSql);
            }

            System.out.println("Databáze byla inicializována!");

            if (conn != null && !conn.isClosed()) {
                System.out.println("Připojení k databázi bylo úspěšné.");
            } else {
                System.out.println("Chyba při připojování k databázi.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Chyba při inicializaci databáze.");
        }
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }


    private static void executeMultipleStatements(Statement stmt, String sql) throws SQLException {
        String[] commands = sql.split(";");
        for (String command : commands) {
            command = command.trim();
            if (!command.isEmpty()) {
                stmt.execute(command);
            }
        }
    }


    private static String loadSQLFromResources(String path) throws IOException {
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IOException("Soubor nebyl nalezen: " + path);
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}