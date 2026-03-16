/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import tacebook.model.Message;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class MessageDB {

    /**
     * Métoido que guarda un mensaje en el primer lugar del array de mensajes
     * del usuario destino
     *
     * @param message Mensaje para un perfil
     * @throws java.sql.SQLException
     */
    public static void save(Message message) throws java.sql.SQLException{
        message.destProfile.messages.addFirst(message);
    }

    /**
     * En la parte 2 eso no hace nada, luego ya veremos
     *
     * @param message Mensaje para un perfil
     * @throws java.sql.SQLException
     */
    public static void update(Message message) throws java.sql.SQLException{

    }

    /**
     * Método que borra el mensaje elegido del array de mensajes del perfil
     * destino
     *
     * @param message Mensaje para un perfil
     * @throws java.sql.SQLException
     */
    public static void remove(Message message) throws java.sql.SQLException{
        message.destProfile.messages.remove(message);
    }
}
