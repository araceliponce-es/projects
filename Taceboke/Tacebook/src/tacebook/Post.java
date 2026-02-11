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
public class Post {

    private int id;
    private String text;
    private Date date = new Date();

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

}
