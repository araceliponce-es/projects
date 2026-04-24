/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.util.Calendar;
import tacebook.model.Comment;
import tacebook.model.Message;
import tacebook.model.Post;
import tacebook.model.Profile;

/**
 *
 * @author araceli
 */
public class DemoData {

    private static Calendar cal = Calendar.getInstance();

    public static void load() throws PersistenceException {

        // 1. Crear usuarios
        Profile a = new Profile("a", "123", "Hola soy A");
        Profile b = new Profile("b", "123", "Hola soy B");
        Profile c = new Profile("c", "123", "Hola soy C");

        ProfileDB.save(a);
        ProfileDB.save(b);
        ProfileDB.save(c);

        // 2. Relaciones (requests + friends)
        ProfileDB.saveFriendshipRequest(a,b); 
        ProfileDB.saveFriendshipRequest(b,c);

        ProfileDB.saveFriendship(a, b); // A <-> B amigos

        // 3. Posts
        Post post1 = new Post("primer post de a ", a);
        Post post2 = new Post("Buenos días", b);

        PostDB.save(post1);
        PostDB.save(post2);

        // 4. Likes
        PostDB.saveLike(post1, b);
        PostDB.saveLike(post1, c);

        // 5. Comentarios
        cal.add(Calendar.DAY_OF_MONTH, -5); //hace 5 dias
        Comment c1 = new Comment(0, cal.getTime(), "Buen post!", post1, b);

        cal.add(Calendar.HOUR, -6); //hace 6 horas
        Comment c2 = new Comment(0, cal.getTime(), "Buen post!", post1, b);

        CommentDB.save(c1);
        CommentDB.save(c2);

        // 6. Mensajes
        cal.add(Calendar.HOUR, -6); //hace 6 horas
        Message m1 = new Message(0, cal.getTime(), "Hola sin leer", false, a, b);
        Message m2 = new Message(0, cal.getTime(), "Hola leido", true, a, b);

        MessageDB.save(m1);
        MessageDB.save(m2);
    }
}
