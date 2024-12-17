package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Zalivka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZalivkaRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Zalivka> findAll() {
        List<Zalivka> zalivky = new ArrayList<>();
        String query = "SELECT * FROM zalivka";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Zalivka zalivka = new Zalivka();
                zalivka.setId_zalivka(rs.getInt("id_zalivka"));
                zalivka.setPopis(rs.getString("popis"));
                zalivky.add(zalivka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zalivky;
    }

    public Zalivka findById(int id) {
        Zalivka zalivka = null;
        String query = "SELECT * FROM zalivka WHERE id_zalivka = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    zalivka = new Zalivka();
                    zalivka.setId_zalivka(rs.getInt("id_zalivka"));
                    zalivka.setPopis(rs.getString("popis"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zalivka;
    }

    public void save(Zalivka zalivka) {
        String query = "INSERT INTO zalivka (popis) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, zalivka.getPopis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM zalivka WHERE id_zalivka = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}