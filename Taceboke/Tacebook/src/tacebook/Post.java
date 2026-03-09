/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class Post {

    private int id;
    private String text;
    private Date date = new Date();
    private Profile profile;
    private ArrayList<Profile> likeProfiles = new ArrayList<>();

    /**
     * Devuelve el profioe asignado al post
     *
     * @return profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Establece el perfil del post
     *
     * @param profile w`
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Para construir un post se necesita un profile y una string que es el
     * mensaje
     *
     * @param text
     * @param profile
     */
    public Post(String text, Profile profile) {
        this.text = text;
        this.profile = profile;
    }

    /**
     * obtiene el id del post
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * establece el id del post
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param text
     */
    public Post(String text) {
        this.text = text;
    }

    /**
     * obtiene el texto del post
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * establece el texto del post
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * obtiene la fecha del post
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * establece la fecha del post
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * constructor del post
     *
     * @param id
     * @param text
     * @param date
     */
    public Post(int id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    /**
     * A quien haya creado el array de likeProfile: le faltó el get/set, muy mal
     * hecho
     *
     * @return Perfiles que dieron like
     */
    public ArrayList<Profile> getLikeProfiles() {
        return likeProfiles;
    }

    /**
     * Establece los perfiles que le dieron like a una publicación
     *
     * @param likeProfiles
     */
    public void setLikeProfiles(ArrayList<Profile> likeProfiles) {
        this.likeProfiles = likeProfiles;
    }

}
