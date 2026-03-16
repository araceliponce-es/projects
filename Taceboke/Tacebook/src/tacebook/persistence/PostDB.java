/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.persistence;

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
     * @throws java.sql.SQLException
     */
    public static void save(Post post) throws java.sql.SQLException{
        if (post != null && post.getProfile() != null) {
            // 1. Identificamos o perfil autor que vai "dentro" do post
            Profile autor = post.getProfile();

            // 2. Engadimos o post no índice 0 da lista de posts do autor
            // Usamos o índice 0 para que as máis recentes saian primeiro
            autor.getPosts().add(0, post);
        }

    }

    /**
     *
     * @param post
     * @param profile
     * @throws SQLException
     */
    public static void saveLike(Post post, Profile profile) throws java.sql.SQLException{
        post.getLikeProfiles().add(profile);
    }
}
