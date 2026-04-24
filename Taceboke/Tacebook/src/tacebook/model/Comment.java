/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.model;

import java.util.Date;

/**
 * Clase que simula ser un comentario de la mejor red social
 *
 * @author Araceli,Diego,Oscar
 */
public class Comment {

    private int id;
    private Date date;
    private String text;
    private Post post;
    private Profile sourceProfile;

    /**
     * Obtiene el id del comentario
     *
     * @return El id en forma de int
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del comentario
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora del comentario
     *
     * @return La fecha con día y hora a la que se publicó el comentario
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece la fecha del comentario
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtiene el texto del comentario
     *
     * @return Una cadena con el contenido del comentario
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el texto del comentario
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    public Comment(int id, Date date, String text, Post post, Profile sourceProfile) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.post = post;
        this.sourceProfile = sourceProfile;
    }


    /**
     * Obtiene el post sobre el que se hizo el comentario
     *
     * @return El post sobre el que se comentó
     */
    public Post getPost() {
        return post;
    }

    /**
     * Establece el post sobre el que se hizo el comentario
     *
     * @param post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Obtiene el perfil que hizo el comentario
     *
     * @return El perfil que hizo el comentario
     */
    public Profile getSourceProfile() {
        return sourceProfile;
    }

    /**
     * Establece el perfil que hizo el comentario
     *
     * @param sourceProfile
     */
    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

}
