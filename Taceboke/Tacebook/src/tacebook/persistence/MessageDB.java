/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.io.IOException;
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
     * Método que guarda un mensaje en el primer lugar del array de mensajes del
     * usuario destino
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Message message) throws PersistenceException {
        try {
            Connection c = TacebookDB.getConnection();
            try (c) {
                System.out.println("Conexion realizada con exito");
                PreparedStatement stM = c.prepareStatement("INSERT INTO Message VALUES(?,?,?,?,?,?)");
                stM.setInt(1, message.getId());
                stM.setString(2, message.getText());
                stM.setDate(3, (Date) message.getDate());
                stM.setBoolean(4, message.isRead());
                stM.setString(5, message.getSourceProfile().getName());
                stM.setString(6, message.getDestProfile().getName());
                stM.executeUpdate();
                stM.close();
            } catch (SQLException e) {
                System.out.println("Fallo en mensajes");
            }
        } catch (IOException ex) {
             System.out.println("Fallo en mensajaes");
        }
    }

    /**
     * Actualiza si un mensaje fue leído
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void update(Message message) throws PersistenceException{
        try {
            Connection c = TacebookDB.getConnection();
            try (c) {
                System.out.println("Conexion realizada con exito");
                PreparedStatement stM = c.prepareStatement("UPDATE Message SET isRead=? WHERE id=?");
                stM.setBoolean(4, message.isRead());
                stM.setInt(1, message.getId());
                stM.executeUpdate();
                stM.close();
            } catch (SQLException e) {
                System.out.println("Fallo en mensajes");
            }
        } catch (IOException ex) {
            System.getLogger(MessageDB.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    /**
     * Método que borra el mensaje elegido del array de mensajes del perfil
     * destino
     *
     * @param message Mensaje para un perfil
     * @throws tacebook.persistence.PersistenceException
     */
    public static void remove(Message message) throws PersistenceException {

        try {

            Connection c = TacebookDB.getConnection();
            try (c) {
                PreparedStatement stM = c.prepareStatement("DELETE FROM Messages WHERE id = ?");
                stM.setInt(1, message.getId());
                stM.executeUpdate();
                stM.close();
            } catch (SQLException e) {
                System.out.println("Fallo en mensajaes");
            }

        } catch (IOException ex) {
            System.out.println("Fallo en mensajaes");
        }

    }
}
