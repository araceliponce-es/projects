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
 * reemplaza a ArrayWordGenerator
 *
 * @author Araceli,Diego,Óscar
 */
public class DBWordGenerator implements WordGenerator {

    static final String DB_URL = "jdbc:sqlite:words.db";
    static final String SQL_CREATE = """
            CREATE TABLE IF NOT EXISTS table_words (
                word TEXT NOT NULL
            );
        """;
    static final String SQL_FILL = "INSERT INTO table_words VALUES ('guacamole'),('aguacate'),('cilantro'),('cebolla');";
    static final String SQL_DELETE = "delete from table_words ";

    public static void main(String[] args) {

        try (Connection c = DriverManager.getConnection(DB_URL);) {

            System.out.println("conexion con exito");

            try (Statement st = c.createStatement()) {
                //CREA TABLA
                st.executeUpdate(SQL_CREATE);
                System.out.println("tabla creada");

                //LLENA CON VALORES
                PreparedStatement ps = c.prepareStatement(SQL_FILL);
                //insert requiere .executeUpdate
                ps.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String generateWord() throws GenerateWordException {

        String palabra = "";

        String SQL_GET_RANDOM = """
                            SELECT * 
                            FROM table_words
                            ORDER BY RANDOM() 
                            LIMIT 1
                            """;

        try (Connection c = DriverManager.getConnection(DB_URL)) {

            System.out.println("conexion con exito");

            try (Statement st = c.createStatement()) {
                //obtiene random word
                ResultSet rs = st.executeQuery(SQL_GET_RANDOM);
                while (rs.next()) {
                    //obtiene el valor de la columna word
                    palabra = rs.getString("word");
                }
            }

        } catch (SQLException e) {
                       throw new GenerateWordException("error al obtener palabra "+ e.getMessage(),true);
           
        }

        return palabra;

    }

}
