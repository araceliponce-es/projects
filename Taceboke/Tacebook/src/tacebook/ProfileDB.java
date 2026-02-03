/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

/**
 * todo: como hacer global el TacebookDB db???
 * 
 * @author Araceli,Diego,Oscar
 */
public class ProfileDB {

    private String name;
    private String password;
    private String status;
    private int numberOfPosts;

    /**
     * encuentra un Profile usando el nombre de usuario y el numero de posts
     * 
     * usa Tacebookdb como param para poder usar metodos de clase
     *
     * @param name
     * @param numberOfPosts
     * @return objeto Profile encontrado, o null
     */
    public static Profile findByName(TacebookDB db, String name, int numberOfPosts) {

        Profile res = null;

        for (Profile person : db.getProfiles()) {

            if (person.getName().equals(name)) {
                //usuario encontrado por nombre, numero de posts aun no implementado
                res = person;
            }
        }
        return res;
    }

    /**
     * encuentra un Profile usando el nombre de usuario, la contraseña y el numero de posts
     * @param db
     * @param name
     * @param password
     * @param numberOfPosts
     * @return 
     */
    public static Profile findByNameAndPassword(TacebookDB db, String name, String password, int numberOfPosts) {

        Profile res = null;

        for (Profile person : db.getProfiles()) {

            if (person.getName().equals(name) && person.getPassword().equals(password)) {
                res = person;
            }
        }
        return res;
    }

    public static void save(TacebookDB db,Profile profile) {
        ArrayList<Profile> currentProfiles = db.getProfiles();
        currentProfiles.add(profile);
        
        System.out.println("db profiles:-------------");
        for (Profile person : db.getProfiles()) {
            System.out.print(person+" ");
        }
        System.out.println("------------------");
    }

    public static void update(Profile profile) {
    }
}
