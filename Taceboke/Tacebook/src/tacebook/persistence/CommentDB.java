/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import tacebook.model.Comment;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class CommentDB {

    /**
     *Método que almacena el comentario en el array de comentarios del post al que iba dirigido, en la primera posición.
     * @param comment Comentario hecho al post
     */
    public static void save(Comment comment) {
        comment.getPost().getComments().addFirst(comment);
    }
}
