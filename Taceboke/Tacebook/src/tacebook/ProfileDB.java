/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * todo: como hacer global el TacebookDB db??? Clase que implementa la
 * persistencia (almacena) de los perfiles de nuestra red social.
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileDB {

    /**
     * Encuentra un Profile usando el nombre de usuario y el numero de posts y
     * lo devuelve, si no lo encunetra devuelve null
     *
     * @param name
     * @param numberOfPosts
     * @return Objeto Profile encontrado, o null
     */
    public static Profile findByName(String name, int numberOfPosts) {
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
     */
    public static Profile findByNameAndPassword(String name, String password, int numberOfPosts) {
        Profile res = null;

        for (Profile person : TacebookDB.getProfiles()) {
            if (person.getName().equals(name) && person.getPassword().equals(password)) {
                res = person;
            }
        }
        return res;
    }

    public static void save(Profile profile) {
        TacebookDB.profiles.add(profile);

        //¿¿¿¿¿POR QUÉ??????
//        ArrayList<Profile> currentProfiles = db.getProfiles();
//        currentProfiles.add(profile);
//        
//        System.out.println("db profiles:-------------");
//        for (Profile person : db.getProfiles()) {
//            System.out.print(person+" ");
//        }
//        System.out.println("------------------");
    }

    public static void update(Profile profile) {
    }
}
