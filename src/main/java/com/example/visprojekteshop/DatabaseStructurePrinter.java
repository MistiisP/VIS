package com.example.visprojekteshop;

import com.example.visprojekteshop.DatabaseConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStructurePrinter {

    // CHATGPT VAŘIL
    // Kod pro kontrolu print databaze
    public static void printDatabaseStructure() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Získání informací o tabulkách
            ResultSet tables = metaData.getTables(null, null, "%", new String[] {"TABLE"});

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                // Získání informací o sloupcích pro každou tabulku
                ResultSet columns = metaData.getColumns(null, null, tableName, "%");

                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    String isNullable = columns.getString("IS_NULLABLE");

                    System.out.println("\tColumn: " + columnName + " | Type: " + columnType + " | Nullable: " + isNullable);
                }

                // Získání dat pro tuto tabulku
                printTableData(connection, tableName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printTableData(Connection connection, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Získání názvů sloupců
            int columnCount = resultSet.getMetaData().getColumnCount();
            System.out.print("\tData: ");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = resultSet.getMetaData().getColumnName(i);
                System.out.print(columnName + "\t");
            }
            System.out.println();

            // Výpis dat z tabulky
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + "\t");
                }
                System.out.println();
            }
        }
    }
}
