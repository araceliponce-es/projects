/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import tacebook.model.Profile;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que simula ser una BD de nuestra aplicación
 *
 * @author Araceli,Diego,Oscar
 */
public class TacebookDB {

    /**
     * Lista que almacena todos los perfiles de la aplicación
     */
    public static ArrayList<Profile> profiles = new ArrayList<>();

    /**
     * Obtiene todos los perfiles de nuestra aplicación
     *
     * @return
     * @throws tacebook.persistence.PersistenceException
     */
    public static ArrayList<Profile> getProfiles() throws PersistenceException {
        return profiles;
    }

    /**
     * Establece todos los perfiles de nuestra aplicación
     *
     * @param profiles
     * @throws tacebook.persistence.PersistenceException
     */
    public static void setProfiles(ArrayList<Profile> profiles) throws PersistenceException {
        TacebookDB.profiles = profiles;
    }

    /**
     * Método que en la fase 3 no hace nada, cerrará la conexión con la database
     */
    public static void close() {
    }

//    // Referencia á conexión coa BD
    private static Connection connection = null;

    /**
     * Obtén unha única conexión coa base de datos, abríndoa se é necesario
     *
     * @return Conexión coa base de datos aberta
     * @throws PersistenceException Se se produce un erro ao conectar coa BD
     */
    public static Connection getConnection() throws PersistenceException, IOException {

        String rutaBD = "";
     
        try {
            // Abrimos un fluxo sobre un ficheiro que está na carpeta "config"
            // da aplicación. En lugar de "FileManager" hai que poñer o nome da clase na que esteamos
            InputStream input = TacebookDB.class.getClassLoader().getResourceAsStream("resources/config.properties");

            if (input == null) {
                throw new PersistenceException(
                        PersistenceException.CONNECTION_ERROR,
                        "No se puede leer config.properties"
                );
            }

            // Cargamos as propiedades do ficheiro
            Properties prop = new Properties();
            prop.load(input);
            // Obtemos o valor de dúas propiedades e pechamos o fluxo
            String db = prop.getProperty("db");

            input.close();
           
            rutaBD = db;

            if (rutaBD != null) {
                DriverManager.getConnection(rutaBD);
            }

            return DriverManager.getConnection(rutaBD);
        } catch (SQLException e) {
            throw new PersistenceException(PersistenceException.CONNECTION_ERROR, e.getMessage());
        }

    }

}
