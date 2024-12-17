package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.TypPlatby;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypPlatbyRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<TypPlatby> findAll() {
        List<TypPlatby> typyPlatby = new ArrayList<>();
        String query = "SELECT * FROM typ_platby";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                TypPlatby typPlatby = new TypPlatby();
                typPlatby.setId_typ_platby(rs.getLong("id_typ_platby"));
                typPlatby.setNazev(rs.getString("nazev"));
                typPlatby.setPopis(rs.getString("popis"));
                typPlatby.setMaxcena(rs.getInt("maxcena"));
                typPlatby.setPoplatek(rs.getInt("poplatek"));
                typyPlatby.add(typPlatby);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typyPlatby;
    }

    public TypPlatby findById(long id) {
        TypPlatby typPlatby = null;
        String query = "SELECT * FROM typ_platby WHERE id_typ_platby = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    typPlatby = new TypPlatby();
                    typPlatby.setId_typ_platby(rs.getLong("id_typ_platby"));
                    typPlatby.setNazev(rs.getString("nazev"));
                    typPlatby.setPopis(rs.getString("popis"));
                    typPlatby.setMaxcena(rs.getInt("maxcena"));
                    typPlatby.setPoplatek(rs.getInt("poplatek"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typPlatby;
    }

    public void save(TypPlatby typPlatby) {
        String query = "INSERT INTO typ_platby (nazev, popis, maxcena, poplatek) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, typPlatby.getNazev());
            pstmt.setString(2, typPlatby.getPopis());
            pstmt.setInt(3, typPlatby.getMaxcena());
            pstmt.setInt(4, typPlatby.getPoplatek());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM typ_platby WHERE id_typ_platby = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}