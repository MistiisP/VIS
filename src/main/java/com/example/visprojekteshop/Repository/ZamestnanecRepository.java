package com.example.visprojekteshop.Repository;

import com.example.visprojekteshop.Entity.Zamestnanec;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZamestnanecRepository {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public List<Zamestnanec> findAll() {
        List<Zamestnanec> zamestnanci = new ArrayList<>();
        String query = "SELECT * FROM zamestnanec";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Zamestnanec zamestnanec = new Zamestnanec();
                zamestnanec.setId_zamestnanec(rs.getLong("id_zamestnanec"));
                zamestnanec.setOsoba_id(rs.getLong("osoba_id"));
                zamestnanec.setPlat(rs.getInt("plat"));
                zamestnanec.setPracovni_pozice(rs.getString("pracovni_pozice"));
                zamestnanec.setPracovni_telefon(rs.getInt("pracovni_telefon"));
                zamestnanci.add(zamestnanec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zamestnanci;
    }

    public Zamestnanec findById(long id) {
        Zamestnanec zamestnanec = null;
        String query = "SELECT * FROM zamestnanec WHERE id_zamestnanec = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    zamestnanec = new Zamestnanec();
                    zamestnanec.setId_zamestnanec(rs.getLong("id_zamestnanec"));
                    zamestnanec.setOsoba_id(rs.getLong("osoba_id"));
                    zamestnanec.setPlat(rs.getInt("plat"));
                    zamestnanec.setPracovni_pozice(rs.getString("pracovni_pozice"));
                    zamestnanec.setPracovni_telefon(rs.getInt("pracovni_telefon"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zamestnanec;
    }

    public void save(Zamestnanec zamestnanec) {
        String query = "INSERT INTO zamestnanec (osoba_id, plat, pracovni_pozice, pracovni_telefon) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, zamestnanec.getOsoba_id());
            pstmt.setInt(2, zamestnanec.getPlat());
            pstmt.setString(3, zamestnanec.getPracovni_pozice());
            pstmt.setInt(4, zamestnanec.getPracovni_telefon());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        String query = "DELETE FROM zamestnanec WHERE id_zamestnanec = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}