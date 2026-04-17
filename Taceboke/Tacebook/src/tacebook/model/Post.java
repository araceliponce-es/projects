/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.model;

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
    private ArrayList<Comment> comments = new ArrayList<>();
    private Profile author;

    /**
     * Devuelve el profile asignado al post
     *
     * @return El perfil sobre el que se hizo el post (no siempre es el que lo
     * creó)
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Establece el perfil del post
     *
     * @param profile
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Constructor del post. Para construir un post se necesita un profile y una
     * string que es el mensaje
     *
     * @param text
     * @param profile
     */
    public Post(String text, Profile profile) {
        this.text = text;
        this.profile = profile;
    }

    /**
     * Obtiene el id del post
     *
     * @return El id en forma de int
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del post
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Otro constructor? que sólo recibe el texto del post
     *
     * @param text
     */
    public Post(String text) {
        this.text = text;
    }

    /**
     * Obtiene el texto del post
     *
     * @return Una cadena con el contenido del post
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el texto del post
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Obtiene la fecha del post
     *
     * @return La fecha con día y hora a la que se publicó el post
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece la fecha del post
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Constructor del post. ¿Por qué hay como tres constructores? TODO:Explicar
     * a Diego
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
     * @return Lista de perfiles que dieron like
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

    /**
     * Obtiene el array de comentarios hechos sobre el post
     *
     * @return Lista de comentarios del post
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Establece el array de comentarios hechos sobre el post
     *
     * @param comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Obtiene el autor del post
     *
     * @return Perfil que hizo el post
     */
    public Profile getAuthor() {
        return author;
    }

    /**
     * Establece el autor del post
     *
     * @param author
     */
    public void setAuthor(Profile author) {
        this.author = author;
    }

}
