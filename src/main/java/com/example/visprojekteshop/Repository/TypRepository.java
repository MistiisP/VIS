package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Typ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Typ> findAll() {
        List<Typ> typy = new ArrayList<>();
        String query = "SELECT * FROM typ";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Typ typ = new Typ();
                typ.setId_typ(rs.getInt("id_typ"));
                typ.setNazev(rs.getString("nazev"));
                typ.setPopis(rs.getString("popis"));
                typy.add(typ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typy;
    }

    public Typ findById(int id) {
        Typ typ = null;
        String query = "SELECT * FROM typ WHERE id_typ = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    typ = new Typ();
                    typ.setId_typ(rs.getInt("id_typ"));
                    typ.setNazev(rs.getString("nazev"));
                    typ.setPopis(rs.getString("popis"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typ;
    }

    public void save(Typ typ) {
        String query = "INSERT INTO typ (nazev, popis) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, typ.getNazev());
            pstmt.setString(2, typ.getPopis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM typ WHERE id_typ = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}