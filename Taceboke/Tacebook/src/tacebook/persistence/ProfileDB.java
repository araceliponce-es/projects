/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tacebook.model.Profile;
import java.sql.SQLException;

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
    public static Profile findByName(String name) throws PersistenceException {
        Profile res = null;
        try {

            for (Profile person : TacebookDB.getProfiles()) {
                if (person.getName().equals(name)) {
                    //usuario encontrado por nombre, numero de posts aun no implementado
                    res = person;
                }
            }

            Connection c = TacebookDB.getConnection();
            try (c) {
                System.out.println("Conexion realizada con exito");
                PreparedStatement stPf = c.prepareStatement("SELECT * FROM Profile WHERE name=?");
                stPf.setString(1, name);
                ResultSet rst = stPf.executeQuery();
                rst.next();
                rst.getString("name");
                rst.getString("password");
                rst.getString("status");
                rst.close();
                stPf.close();
            } catch (SQLException e) {
                System.out.println("Fallo en profiles");

            }
        } catch (IOException ex) {
            System.getLogger(ProfileDB.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
    public static Profile findByName(String name, int numberOfPosts) throws PersistenceException {
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
    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts)
            throws PersistenceException {

        Profile res = null;

        try (Connection c = TacebookDB.getConnection()) {

            PreparedStatement st = c.prepareStatement(
                    "SELECT name, password, status FROM Profile WHERE name=? AND password=?"
            );

            st.setString(1, name);
            st.setString(2, getPasswordHash(password));

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                res = new Profile(
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * Almacena el perfil en la BD
     *
     * @param profile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Profile profile) throws PersistenceException {
        try {
            TacebookDB.profiles.add(profile);

            try (Connection c = TacebookDB.getConnection();) {
                System.out.println("Conexion realizada con exito");
                PreparedStatement stPf = c.prepareStatement("INSERT INTO Profile VALUES(?,?,?)");
                stPf.setString(1, profile.getName());
                stPf.setString(2, getPasswordHash(profile.getPassword()));
                stPf.setString(3, profile.getStatus());
                stPf.executeUpdate();
                stPf.close();

                TacebookDB.profiles.add(profile);
            } catch (SQLException e) {
                System.out.println("Fallo en profiles");
                e.printStackTrace();
            } catch (NoSuchAlgorithmException ex) {
                System.getLogger(ProfileDB.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (IOException ex) {
            System.getLogger(ProfileDB.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    /**
     * Actualiza el perfil en la BD (de momento no hace nada)
     *
     * @param profile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void update(Profile profile) throws PersistenceException {
    }

    /**
     * Añade en el array @friendshipRequest del destProfile el sourceProfile
     * envia solicitud de amistad (a esta persona, desde esta persona)
     * (receiver,sender)
     *
     * @param destProfile
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void saveFriendshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException {

        // Compara los profiles con nulo para saber si existen
        if (destProfile == null || sourceProfile == null) {
            return;
        }

        // evita duplicados
        if (!destProfile.getFriendshipsRequest().contains(sourceProfile)) {
            destProfile.getFriendshipsRequest().add(sourceProfile);
        }
    }

    /**
     * Elimina en el array @friendshipRequest del destProfile el sourceProfile
     *
     * @param destProfile
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void removeFriendshipRequest(Profile destProfile, Profile sourceProfile) throws PersistenceException {
        if (destProfile != null && sourceProfile != null) {
            // Si los profiles existen obtiene el arrayList de solicitudes del
            // perfil destino y elimina el perfil del que viene la solicitud
            destProfile.getFriendshipsRequest().remove(sourceProfile);
        }
    }

    /**
     * Guarda el profile 1 en el arrayList de friends del profile 2 y viceversa
     *
     * @param profile1
     * @param profile2
     * @throws tacebook.persistence.PersistenceException
     */
    public static void saveFriendship(Profile profile1, Profile profile2) throws PersistenceException {
        if (profile1 != null && profile2 != null) {
            profile1.getFriends().add(profile2);
            profile2.getFriends().add(profile1);
        }
    }

    private static String getPasswordHash(String password) throws NoSuchAlgorithmException {
        // Calculamos e obtemos o Hash
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        byte[] myHash = messageDigest.digest();
        // Codificamos o Hash en hexadecimal        
        BigInteger number = new BigInteger(1, myHash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

}
