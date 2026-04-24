/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.model;

import java.util.Date;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class Message {

    private int id;
    private Date date;
    private String text;
    private boolean read;

    /**
     * ¿Por qué están public estas cosas?
     *
     */
    public Profile destProfile;

    /**
     *
     */
    public Profile sourceProfile;

    /**
     * Obtiene el id del mensaje
     *
     * @return El id en forma de int
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del mensaje
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el texto del mensaje
     *
     * @return Una cadena con el contenido del mensaje
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el texto del mensaje
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Obtiene la fecha del mensaje
     *
     * @return La fecha con día y hora a la que se publicó el mensaje
     */
    public Date getDate() {
        return date;
    }

    /**
     * Establece la fecha del mensaje
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtiene el valor booleano de mensaje leido o no
     *
     * @return Si el mensaje se leyó o no
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Establece el valor booleano de mensaje leido o no
     *
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Obtiene el Profile del destinatario
     *
     * @return El perfil al que se envió el mensaje
     */
    public Profile getDestProfile() {
        return destProfile;
    }

    /**
     * Establece el Profile del destinatario
     *
     * @param destProfile
     */
    public void setDestProfile(Profile destProfile) {
        this.destProfile = destProfile;
    }

    /**
     * Obtiene el Profile del emisor
     *
     * @return El perfil que escribió y envió el mensaje
     */
    public Profile getSourceProfile() {
        return sourceProfile;
    }

    /**
     * Establece el Profile del emisor
     *
     * @param sourceProfile
     */
    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    /**
     * Constructor del mensaje
     *
     * @param id
     * @param text
     * @param date
     * @param read
     * @param destProfile
     * @param sourceProfile
     */
    public Message(int id, Date date, String text, boolean read, Profile destProfile, Profile sourceProfile) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.read = read;
        this.destProfile = destProfile;
        this.sourceProfile = sourceProfile;
    }

}
