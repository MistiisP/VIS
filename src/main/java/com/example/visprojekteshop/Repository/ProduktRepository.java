package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Produkt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduktRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Produkt> findAll() {
        List<Produkt> produkty = new ArrayList<>();
        String query = "SELECT * FROM produkt";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Produkt produkt = new Produkt();
                produkt.setId_produkt(rs.getLong("id_produkt"));
                produkt.setNazev(rs.getString("nazev"));
                produkt.setPopis(rs.getString("popis"));
                produkt.setCena(rs.getInt("cena"));
                produkt.setSkladem(rs.getInt("skladem"));
                produkt.setJedoprava(rs.getBoolean("jedoprava"));
                produkt.setKategorie_id(rs.getInt("kategorie_id"));
                produkt.setSlunce_id(rs.getInt("slunce_id"));
                produkt.setZalivka_id(rs.getInt("zalivka_id"));
                produkt.setTyp_id(rs.getInt("typ_id"));
                produkty.add(produkt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produkty;
    }

    public Produkt findById(long id) {
        Produkt produkt = null;
        String query = "SELECT * FROM produkt WHERE id_produkt = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    produkt = new Produkt();
                    produkt.setId_produkt(rs.getLong("id_produkt"));
                    produkt.setNazev(rs.getString("nazev"));
                    produkt.setPopis(rs.getString("popis"));
                    produkt.setCena(rs.getInt("cena"));
                    produkt.setSkladem(rs.getInt("skladem"));
                    produkt.setJedoprava(rs.getBoolean("jedoprava"));
                    produkt.setKategorie_id(rs.getInt("kategorie_id"));
                    produkt.setSlunce_id(rs.getInt("slunce_id"));
                    produkt.setZalivka_id(rs.getInt("zalivka_id"));
                    produkt.setTyp_id(rs.getInt("typ_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produkt;
    }

    public void save(Produkt produkt) {
        String query = "INSERT INTO produkt (nazev, popis, cena, skladem, jedoprava, kategorie_id, slunce_id, zalivka_id, typ_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, produkt.getNazev());
            pstmt.setString(2, produkt.getPopis());
            pstmt.setInt(3, produkt.getCena());
            pstmt.setInt(4, produkt.getSkladem());
            pstmt.setBoolean(5, produkt.isJedoprava());
            pstmt.setInt(6, produkt.getKategorie_id());
            pstmt.setInt(7, produkt.getSlunce_id());
            pstmt.setInt(8, produkt.getZalivka_id());
            pstmt.setInt(9, produkt.getTyp_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM produkt WHERE id_produkt = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}