/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;

/**
 * modelo
 * 
 * @author Araceli,Diego,Oscar
 */
public class Profile {
    
    private String name, password, status;
    public ArrayList<Message> messages = new ArrayList<>();
    public ArrayList<Profile> friendshipRequest = new ArrayList<>();
    public ArrayList<Profile> friends = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();
    
    /**
     * Obtiene el array list de post que tiene ese 
     * 
     * @return ArrayList<Post>
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }
    
    
    /**
     * Obtiene el array list de profiles quee tiene establecidos como
     *  friends
     * @return ArrayList<Profile>
     */
    public ArrayList<Profile> getFriends() {
        return friends;
    }
    
    /**
     * Obtiene las un array de solicitudes de amistad
     * que corresponda a el perfil
     * 
     * @return ArrayList<Profile>
     */
    public ArrayList<Profile> getFriendshipRequest() {
        return friendshipRequest;
    }

    /**
     * constructor del perfil
     * @param name
     * @param password
     * @param status
     */
    public Profile(String name, String password, String status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    /**
     * obtiene el nombre
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * establece el nombre
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtiene el password
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * establece el password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * obtiene el status
     * 
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * establece el status
     * 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
