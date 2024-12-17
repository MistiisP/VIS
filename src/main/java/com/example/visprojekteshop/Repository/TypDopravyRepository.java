package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.TypDopravy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypDopravyRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<TypDopravy> findAll() {
        List<TypDopravy> typyDopravy = new ArrayList<>();
        String query = "SELECT * FROM typ_dopravy";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                TypDopravy typDopravy = new TypDopravy();
                typDopravy.setId_typ_dopravy(rs.getLong("id_typ_dopravy"));
                typDopravy.setNazev(rs.getString("nazev"));
                typDopravy.setPopis(rs.getString("popis"));
                typDopravy.setPoplatek(rs.getInt("poplatek"));
                typyDopravy.add(typDopravy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typyDopravy;
    }

    public TypDopravy findById(long id) {
        TypDopravy typDopravy = null;
        String query = "SELECT * FROM typ_dopravy WHERE id_typ_dopravy = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    typDopravy = new TypDopravy();
                    typDopravy.setId_typ_dopravy(rs.getLong("id_typ_dopravy"));
                    typDopravy.setNazev(rs.getString("nazev"));
                    typDopravy.setPopis(rs.getString("popis"));
                    typDopravy.setPoplatek(rs.getInt("poplatek"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typDopravy;
    }

    public void save(TypDopravy typDopravy) {
        String query = "INSERT INTO typ_dopravy (nazev, popis, maxcena, poplatek) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, typDopravy.getNazev());
            pstmt.setString(2, typDopravy.getPopis());
            pstmt.setInt(4, typDopravy.getPoplatek());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM typ_dopravy WHERE id_typ_dopravy = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}