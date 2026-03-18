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
    public static ArrayList<Profile> getProfiles() throws PersistenceException{
        return profiles;
    }

    /**
     * Establece todos los perfiles de nuestra aplicación
     *
     * @param profiles
     * @throws tacebook.persistence.PersistenceException
     */
    public static void setProfiles(ArrayList<Profile> profiles) throws PersistenceException{
        TacebookDB.profiles = profiles;
    }
    
    /**
     * Método que en la fase 3 no hace nada, cerrará la conexión con la database
     */
    public static void close(){}
}
