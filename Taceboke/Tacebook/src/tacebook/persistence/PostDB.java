/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tacebook.model.Post;
import tacebook.model.Profile;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class PostDB {

    /**
     *
     * @param post
     * @throws tacebook.persistence.PersistenceException
     */
    public static void save(Post post) throws PersistenceException{
//        if (post != null && post.getProfile() != null) {
//            // 1. Identificamos o perfil autor que vai "dentro" do post
//            Profile autor = post.getProfile();
//
//            // 2. Engadimos o post no índice 0 da lista de posts do autor
//            // Usamos o índice 0 para que as máis recentes saian primeiro
//            autor.getPosts().add(0, post);
//        }
        Connection c=TacebookDB.getConnection();
        try (c) {
            System.out.println("Conexion realizada con exito");
            PreparedStatement stP = c.prepareStatement("INSERT INTO Post VALUES(?,?,?,?,?)");
            stP.setInt(1, post.getId());
            stP.setString(2, post.getText());
            stP.setDate(3, (Date) post.getDate());
            stP.setString(4, post.getProfile().getName());
            stP.setString(5, post.getAuthor().getName());
            stP.executeUpdate();
            stP.close();
        } catch (SQLException e) {
            System.out.println("Fallo en posts");
        }

    }

    /**
     *
     * @param post
     * @param profile
     * @throws tacebook.persistence.PersistenceException
     */
    public static void saveLike(Post post, Profile profile) throws PersistenceException{
        post.getLikeProfiles().add(profile);
        
        Connection c=TacebookDB.getConnection();
        try (c) {
            System.out.println("Conexion realizada con exito");
            PreparedStatement stP = c.prepareStatement("INSERT INTO ProfileLikesPost VALUES(?,?,?,?,?)");
            stP.setInt(1, post.getId());
            stP.setString(2, profile.getName());
            stP.executeUpdate();
            stP.close();
        } catch (SQLException e) {
            System.out.println("Fallo en Posts");
        }
    }
}
