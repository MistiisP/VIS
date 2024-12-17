package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Osoba;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OsobaRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Osoba> findAll() {
        List<Osoba> osoby = new ArrayList<>();
        String query = "SELECT * FROM osoba";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Osoba osoba = new Osoba();
                osoba.setId(rs.getLong("id"));
                osoba.setJmeno(rs.getString("jmeno"));
                osoba.setPrijmeni(rs.getString("prijmeni"));
                osoba.setEmail(rs.getString("email"));
                osoba.setTelefon(rs.getInt("telefon"));
                osoba.setAdresa(rs.getString("adresa"));
                osoba.setHeslo(rs.getString("heslo"));
                osoby.add(osoba);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return osoby;
    }

    public Osoba findById(long id) {
        Osoba osoba = null;
        String query = "SELECT * FROM osoba WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    osoba = new Osoba();
                    osoba.setId(rs.getLong("id"));
                    osoba.setJmeno(rs.getString("jmeno"));
                    osoba.setPrijmeni(rs.getString("prijmeni"));
                    osoba.setEmail(rs.getString("email"));
                    osoba.setTelefon(rs.getInt("telefon"));
                    osoba.setAdresa(rs.getString("adresa"));
                    osoba.setHeslo(rs.getString("heslo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return osoba;
    }

    public void save(Osoba osoba) {
        String query = "INSERT INTO osoba (jmeno, prijmeni, email, telefon, adresa, heslo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, osoba.getJmeno());
            pstmt.setString(2, osoba.getPrijmeni());
            pstmt.setString(3, osoba.getEmail());
            pstmt.setInt(4, osoba.getTelefon());
            pstmt.setString(5, osoba.getAdresa());
            pstmt.setString(6, osoba.getHeslo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM osoba WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}