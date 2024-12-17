package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Kategorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategorieRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Kategorie> findAll() {
        List<Kategorie> kategorien = new ArrayList<>();
        String query = "SELECT * FROM Kategorie";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Kategorie kategorie = new Kategorie();
                kategorie.setId(rs.getInt("id"));
                kategorie.setNazev(rs.getString("name"));
                kategorien.add(kategorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategorien;
    }

    public Kategorie findById(long id) {
        Kategorie kategorie = null;
        String query = "SELECT * FROM Kategorie WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    kategorie = new Kategorie();
                    kategorie.setId(rs.getInt("id"));
                    kategorie.setNazev(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategorie;
    }

    public List<Kategorie> findByName(String name) {
        List<Kategorie> kategorien = new ArrayList<>();
        String query = "SELECT * FROM Kategorie WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Kategorie kategorie = new Kategorie();
                    kategorie.setId(rs.getInt("id"));
                    kategorie.setNazev(rs.getString("name"));
                    kategorien.add(kategorie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kategorien;
    }
}