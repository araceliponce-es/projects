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
public class Comment {
    private int id;
    private Date date;
    private String text;

    /**
     * obtiene el id del comentario
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * establece el id del comentario
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obtiene la fecha del comentario
     * @return 
     */
    public Date getDate() {
        return date;
    }

    /**
     * establece la fecha del comentario
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * obtiene el texto del comentario
     * @return 
     */
    public String getText() {
        return text;
    }

    /**
     * establece el texto del comentario
     * @param text 
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * constructor del comentario
     * @param id
     * @param date
     * @param text 
     */
    public Comment(int id, Date date, String text) {
        this.id = id;
        this.date = date;
        this.text = text;
    }

    
    
    
    
}
