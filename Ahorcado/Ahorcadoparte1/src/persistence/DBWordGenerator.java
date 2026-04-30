/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import ahorcado.parte1.ui.GenerateWordException;
import ahorcado.parte1.ui.WordGenerator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Araceli,Diego,Óscar
 */
public class DBWordGenerator implements WordGenerator {

    static final String DB_URL = "jdbc:sqlite:words.db";
    static final String SQL_CREATE = """
            CREATE TABLE IF NOT EXISTS table_words (
                word TEXT NOT NULL,
            );
        """;
   static final String SQL_FILL = "INSERT INTO words VALUES 'guacamole'";

    public static void main(String[] args) {
        //try with resources

        try (Connection c = DriverManager.getConnection(DB_URL);) {

            System.out.println("creado con exito");

            try (Statement st = c.createStatement()) {
                st.executeUpdate(SQL_CREATE);
            }

            String currentSql = "select * from table_words";

            //try usando ps y resulset como resources
            try (PreparedStatement ps = c.prepareStatement(currentSql); ResultSet rs = ps.executeQuery()) {

                ps.executeUpdate(SQL_FILL);
                
//                while (rs.next()) {
//                    System.out.println(rs.getString("word"));
//                }

            } catch (Exception e) {
                System.out.println("exception " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String generateWord() throws GenerateWordException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
