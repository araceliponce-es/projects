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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Profile getDestProfile() {
        return destProfile;
    }

    public void setDestProfile(Profile destProfile) {
        this.destProfile = destProfile;
    }

    public Profile getSourceProfile() {
        return sourceProfile;
    }

    public void setSourceProfile(Profile sourceProfile) {
        this.sourceProfile = sourceProfile;
    }

    public Message(int id, String text, boolean read, Profile destProfile, Profile sourceProfile) {
        this.id = id;
        this.text = text;
        this.read = read;
        this.destProfile = destProfile;
        this.sourceProfile = sourceProfile;
    }
    
    

    public Profile destProfile, sourceProfile;

}
