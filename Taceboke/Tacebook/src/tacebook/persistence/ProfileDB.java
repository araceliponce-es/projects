/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import tacebook.model.Profile;

/**
 * Clase que implementa la persistencia (almacenamiento) de los perfiles de la
 * aplicación
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileDB {

    /**
     * ? metodo para encontrar profile por el name, sin otro parametro
     *
     * @param name
     * @return
     * @throws tacebook.persistence.PersistenceException
     */
    public static Profile findByName(String name) throws PersistenceException{
        Profile res = null;

        for (Profile person : TacebookDB.getProfiles()) {

            if (person.getName().equals(name)) {
                //usuario encontrado por nombre, numero de posts aun no implementado
                res = person;
            }

        }
        return res;
    }

    /**
     * Encuentra un Profile usando el nombre de usuario y el numero de posts y
     * lo devuelve, si no lo encunetra devuelve null
     *
     * @param name Nombre del usuario que quieres buscar
     * @param numberOfPosts Número de posts que se quieren recuperar
     * @return Objeto Profile encontrado, o null
     * @throws tacebook.persistence.PersistenceException
     */
    public static Profile findByName(String name, int numberOfPosts) throws PersistenceException{
        Profile res = null;

        for (Profile person : TacebookDB.getProfiles()) {

            if (person.getName().equals(name)) {
                //usuario encontrado por nombre, numero de posts aun no implementado
                res = person;
            }

        }
        return res;
    }

    /**
     * Encuentra un Profile usando el nombre de usuario, la contraseña y el
     * numero de posts y lo devuelve, si no lo encunetra devuelve null
     *
     * @param name
     * @param password
     * @param numberOfPosts
     * @return Perfil de usuario encontrado, o null
     * @throws tacebook.persistence.PersistenceException
     */
    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) throws PersistenceException{
        Profile res = null;

        for (Profile person : TacebookDB.getProfiles()) {
            if (person.getName().equals(name) && person.getPassword().equals(password)) {
                res = person;
            }
        }
        return res;
    }

    /**
     * Almacena el perfil en la BD
     *
     * @param profile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Profile profile) throws PersistenceException{
        TacebookDB.profiles.add(profile);
    }

    /**
     * Actualiza el perfil en la BD (de momento no hace nada)
     *
     * @param profile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void update(Profile profile) throws PersistenceException{
    }

    /**
     * Añade en el array @friendshipRequest del destProfile el sourceProfile
     *
     * @param destProfile
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void saveFriendshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException{
        // Compara los profiles con nulo para saber si existen
        if (destProfile != null && sourceProfile != null) {
            // Si los profiles existen obtiene el arrayList de solicitudes del
            // perfil destino y le añade el perfil del que viene la solicitud
            destProfile.getFriendshipRequest().add(sourceProfile);
        }
    }

    /**
     * Elimina en el array @friendshipRequest del destProfile el sourceProfile
     *
     * @param destProfile
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void removeFriendshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException{
        if (destProfile != null && sourceProfile != null) {
            // Si los profiles existen obtiene el arrayList de solicitudes del
            // perfil destino y elimina el perfil del que viene la solicitud
            destProfile.getFriendshipRequest().remove(sourceProfile);
        }
    }

    /**
     * Guarda el profile 1 en el arrayList de friends del profile 2 y viceversa
     *
     * @param profile1
     * @param profile2
     * @throws tacebook.persistence.PersistenceException
     */
    public static void saveFriendship(Profile profile1, Profile profile2) throws PersistenceException{
        if (profile1 != null && profile2 != null) {
            profile1.getFriends().add(profile2);
            profile1.getFriends().add(profile2);
        }
    }

}
