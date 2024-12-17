package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Zakaznik;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZakaznikRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Zakaznik> findAll() {
        List<Zakaznik> zakaznici = new ArrayList<>();
        String query = "SELECT * FROM zakaznik";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Zakaznik zakaznik = new Zakaznik();
                zakaznik.setId_zakaznik(rs.getLong("id_zakaznik"));
                zakaznik.setOsoba_id(rs.getLong("osoba_id"));
                zakaznici.add(zakaznik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zakaznici;
    }

    public Zakaznik findById(long id) {
        Zakaznik zakaznik = null;
        String query = "SELECT * FROM zakaznik WHERE id_zakaznik = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    zakaznik = new Zakaznik();
                    zakaznik.setId_zakaznik(rs.getLong("id_zakaznik"));
                    zakaznik.setOsoba_id(rs.getLong("osoba_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zakaznik;
    }

    public void save(Zakaznik zakaznik) {
        String query = "INSERT INTO zakaznik (osoba_id) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, zakaznik.getOsoba_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM zakaznik WHERE id_zakaznik = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}