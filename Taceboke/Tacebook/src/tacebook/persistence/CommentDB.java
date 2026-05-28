/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tacebook.model.Comment;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class CommentDB {

    /**
     *Método que almacena el comentario en el array de comentarios del post al que iba dirigido, en la primera posición.
     * @param comment Comentario hecho al post
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Comment comment) throws PersistenceException{
        comment.getPost().getComments().addFirst(comment);
    }
    
    public static void saveDB(Comment comment) throws PersistenceException{
        Connection c=TacebookDB.getConnection();
        try (c) {
            System.out.println("Conexion realizada con exito");
            PreparedStatement stC = c.prepareStatement("INSERT INTO COMMENT VALUES(?,?,?,?,?)");
            stC.setInt(1, comment.getId());
            stC.setString(2, comment.getText());
            stC.setDate(3, (Date) comment.getDate());
            stC.setString(4, comment.getSourceProfile().getName());
            stC.setInt(5, comment.getPost().getId());
            stC.close();
            

        } catch (SQLException e) {
            System.out.println("Fallo en comentarios");
        }
    }
    
    
    
    
    
    
}
