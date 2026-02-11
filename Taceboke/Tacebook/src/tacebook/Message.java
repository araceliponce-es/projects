/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Date;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class Message {

    private int id;
    private String text;
    private Date date = new Date();
    private boolean read;

    public Profile destProfile; 
    public Profile sourceProfile;

    /**
     * obtiene el id del mensaje
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * establece el id del mensaje
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obtiene el texto del mensaje
     * 
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * establece el texto del mensaje
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * obtiene la fecha del mensaje
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * establece la fecha del mensaje
     * 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * obtiene el valor booleano de mensaje leido o no
     * 
     * @return
     */
    public boolean isRead() {
        return read;
    }

    /**
     * establece el valor booleano de mensaje leido o no
     * 
     * @param read
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * obtiene el Profile del destinatario
     * 
     * @return
     */
    public Profile getDestProfile() {
        return destProfile;
    }

    /**
     * establece el Profile del destinatario
     * @param destProfile
     */
    public void setDestProfile(Profile destProfile) {
        this.destProfile = destProfile;
    }

    /**
     * obtiene el Profile del emisor
     * 
     * @return
     */
    public Profile getSourceProfile() {
        return sourceProfile;
    }

    /**
     * establece el Profile del emisor
     * 
     * @param sourceProfile
     */
    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    /**
     * constructor del mensaje
     * 
     * @param id
     * @param text
     * @param read
     * @param destProfile
     * @param sourceProfile
     */
    public Message(int id, String text, boolean read, Profile destProfile, Profile sourceProfile) {
        this.id = id;
        this.text = text;
        this.read = read;
        this.destProfile = destProfile;
        this.sourceProfile = sourceProfile;
    }
    
 

}
