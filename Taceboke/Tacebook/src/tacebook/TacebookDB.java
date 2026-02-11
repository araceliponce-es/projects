/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

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
     */
    public static ArrayList<Profile> getProfiles() {
        return profiles;
    }

    /**
     * Establece todos los perfiles de nuestra aplicación
     *
     * @param profiles
     */
    public static void setProfiles(ArrayList<Profile> profiles) {
        TacebookDB.profiles = profiles;
    }
}
