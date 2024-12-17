package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Slunce;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SlunceRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Slunce> findAll() {
        List<Slunce> slunceList = new ArrayList<>();
        String query = "SELECT * FROM slunce";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Slunce slunce = new Slunce();
                slunce.setId_slunce(rs.getInt("id_slunce"));
                slunce.setPopis(rs.getString("popis"));
                slunceList.add(slunce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slunceList;
    }

    public Slunce findById(int id) {
        Slunce slunce = null;
        String query = "SELECT * FROM slunce WHERE id_slunce = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    slunce = new Slunce();
                    slunce.setId_slunce(rs.getInt("id_slunce"));
                    slunce.setPopis(rs.getString("popis"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return slunce;
    }

    public void save(Slunce slunce) {
        String query = "INSERT INTO slunce (popis) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, slunce.getPopis());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM slunce WHERE id_slunce = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}