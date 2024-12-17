package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Objednavka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjednavkaRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Objednavka> findAll() {
        List<Objednavka> objednavky = new ArrayList<>();
        String query = "SELECT * FROM objednavka";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Objednavka objednavka = new Objednavka();
                objednavka.setId_objednavka(rs.getLong("id_objednavka"));
                objednavka.setZakaznik_id(rs.getLong("zakaznik_id"));
                objednavka.setDoprava_id(rs.getLong("doprava_id"));
                objednavka.setPlatba_id(rs.getLong("platba_id"));
                objednavka.setDatum(rs.getDate("datum"));
                objednavky.add(objednavka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objednavky;
    }

    public Objednavka findById(long id) {
        Objednavka objednavka = null;
        String query = "SELECT * FROM objednavka WHERE id_objednavka = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    objednavka = new Objednavka();
                    objednavka.setId_objednavka(rs.getLong("id_objednavka"));
                    objednavka.setZakaznik_id(rs.getLong("zakaznik_id"));
                    objednavka.setDoprava_id(rs.getLong("doprava_id"));
                    objednavka.setPlatba_id(rs.getLong("platba_id"));
                    objednavka.setDatum(rs.getDate("datum"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objednavka;
    }

    public void save(Objednavka objednavka) {
        String query = "INSERT INTO objednavka (zakaznik_id, doprava_id, platba_id, datum) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, objednavka.getZakaznik_id());
            pstmt.setLong(2, objednavka.getDoprava_id());
            pstmt.setLong(3, objednavka.getPlatba_id());
            pstmt.setDate(4, new java.sql.Date(objednavka.getDatum().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM objednavka WHERE id_objednavka = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}