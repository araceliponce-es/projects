/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.util.ArrayList;
import tacebook.model.Profile;

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
//    private static Connection connection = null;
//
//    /**
//     * Obtén unha única conexión coa base de datos, abríndoa se é necesario
//     *
//     * @return Conexión coa base de datos aberta
//     * @throws PersistenceException Se se produce un erro ao conectar coa BD
//     */
//    public static Connection getConnection() throws PersistenceException {
//        // Obtemos unha conexión coa base de datos
//        try {
//            if (connection == null) {
//                connection = DriverManager.getConnection("URL", "usuario", "contrasinal");
//            }
//            return connection;
//        } catch (SQLException e) {
//            throw new PersistenceException(PersistenceException.CONNECTION_ERROR, e.getMessage());
//        }
//    }

    
    
}
