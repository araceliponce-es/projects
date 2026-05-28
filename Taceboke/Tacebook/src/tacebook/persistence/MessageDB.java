/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tacebook.model.Message;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class MessageDB {

    /**
     * Método que guarda un mensaje en el primer lugar del array de mensajes
     * del usuario destino
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Message message) throws PersistenceException{
        message.destProfile.messages.addFirst(message);

        Connection c=TacebookDB.getConnection();
        try (c) {
            System.out.println("Conexion realizada con exito");
            PreparedStatement stM = c.prepareStatement("INSERT INTO MESSAGE VALUES(?,?,?,?,?,?)");
            stM.setInt(1, message.getId());
            stM.setString(2, message.getText());
            stM.setDate(3, (Date) message.getDate());
            stM.setBoolean(4, message.isRead());
            stM.setString(5, message.getSourceProfile().getName());
            stM.setString(6, message.getDestProfile().getName());
            stM.close();
            

        } catch (SQLException e) {
            System.out.println("Fallo en comentarios");
        }
    }

    /**
     * En la parte 2 eso no hace nada, luego ya veremos
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void update(Message message) throws PersistenceException{

    }

    /**
     * Método que borra el mensaje elegido del array de mensajes del perfil
     * destino
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void remove(Message message) throws PersistenceException{
        message.destProfile.messages.remove(message);
    }
}
