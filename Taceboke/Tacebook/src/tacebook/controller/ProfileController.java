/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.controller;

import tacebook.view.ProfileView;
import tacebook.persistence.ProfileDB;
import tacebook.persistence.PostDB;
import tacebook.persistence.MessageDB;
import tacebook.persistence.CommentDB;
import java.util.ArrayList;
import java.util.Date;
import tacebook.model.Comment;
import tacebook.model.Message;
import tacebook.model.Post;
import tacebook.model.Profile;
import tacebook.persistence.PersistenceException;

/**
 * Clase controlador del perfil con un atributo ProfileView y Profile, controla
 * las acciones del menú principal
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileController {

    private Profile sessionProfile;
    private ProfileView myView;

    private Profile shownProfile; //almacena el perfil visualizandose actualmentte (puede coincidir o no con el usuario actual

    public ProfileController() {
        myView = new ProfileView(this);
    }

    /**
     * Obtiene el perfil con el que se abre sesión
     *
     * @return
     */
    public Profile getSessionProfile() {
        return sessionProfile;
    }

    /**
     * Establece el perfil con el que se abre sesión
     *
     * @param sessionProfile
     */
    public void setSessionProfile(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
    }

    /**
     * Obtiene la vista del perfil con el que se abre sesión
     *
     * @return
     */
    public ProfileView getMyView() {
        return myView;
    }

    /**
     * Establece la vista del perfil con el que se abre sesión
     *
     * @param myView
     */
    public void setMyView(ProfileView myView) {
        this.myView = myView;
    }

    /**
     * Obtiene el numero de publicaciones a mostrar
     *
     * @return Numero de posts
     */
    public int getPostsShown() {
        return myView.getPostsShown();
    }

    /**
     * Obtiene el perfil que se visualiza
     *
     * @return
     */
    public Profile getShownProfile() {
        return shownProfile;
    }

    /**
     * Establece el perfil que se visualiza y ademas recarga el perfil que se
     * muestra
     *
     * @param shownProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public void setShownProfile(Profile shownProfile) throws PersistenceException {
        this.shownProfile = shownProfile;
        this.reloadProfile();
    }

    /**
     * Obtiene el perfil de la sesion usando ProfileDB y muestra su menú
     *
     * fase 2: shownProfile en lugar de sessionProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public void reloadProfile() throws PersistenceException {
        ProfileDB.update(shownProfile);
    }

    /**
     * Abre una sesión con un perfil y muestra su menú de opciones.
     *
     * fase 2: al iniciar sesion, shownprofile es el perfil propio
     *
     * @param sessionProfile
     */
    public void openSession(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
        this.shownProfile = sessionProfile;
        myView.showProfileMenu(sessionProfile); //muestra opciones de cambiar de sesion o cerrar sesion

    }

    /**
     * Actualiza y guarda los datos del perfil, luego recarga el perfil y lo
     * muestra con los datos actualizados.
     *
     * @param newStatus
     * @throws tacebook.persistence.PersistenceException
     */
    public void updateProfileStatus(String newStatus) throws PersistenceException {
        sessionProfile.setStatus(newStatus);
        ProfileDB.update(sessionProfile);
        reloadProfile();
    }

    // FASE 2 -METODOS:
    /**
     * Crea un novo obxecto "Post", chama á clase "PostDB" para gardalo e chama
     * ao método "reloadProfile" para refrescar a información do perfil.
     *
     * @param text
     * @param destProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public void newPost(String text, Profile destProfile) throws PersistenceException {
        //crea nuevo post y lo guarda en bd
        Post post = new Post(text, destProfile);
        PostDB.save(post);

        //recarga perfil
        reloadProfile();

    }

    /**
     * Crea un novo obxecto "Comment", chama á clase "CommentDB" para gardalo e
     * chama ao método "reloadProfile" para refrescar a información do perfil.
     *
     * @param post
     * @param commentText
     * @throws tacebook.persistence.PersistenceException
     */
    public void newComment(Post post, String commentText) throws PersistenceException {
        Date today = new Date();
        Comment comment = new Comment(post.getComments().size(), today, commentText, post, sessionProfile);
        CommentDB.save(comment);
    }

    //RESTO ESTAN PENDIENTES
    /**
     * Comproba que o perfil da sesión non sexa o autor da publicación e non
     * fixera xa Like sobre a publicación recibida. Se non é así, chama á clase
     * "PostDB" para gardar o Like. En todo caso, refresca a información do
     * perfil chamando a "reloadProfile".
     *
     * @param post
     * @throws tacebook.persistence.PersistenceException
     */
    public void newLike(Post post) throws PersistenceException {
        // guarda el like, solo si el nombre del autor del post NO ES IGUAL al nombre del usuario actual

        if (!post.getAuthor().getName().equalsIgnoreCase(sessionProfile.getName())) {
            PostDB.saveLike(post, shownProfile);
        }

        // en cualquier caso, recargar profile
        reloadProfile();
    }

    /**
     * Comproba que exista un perfil co nome recibido como parámetro, que ese
     * perfil non teña xa amizade co perfil da sesión, e que non haxa xa unha
     * solicitude dese perfil ao perfil da sesión e viceversa. Se non ocorre
     * nada diso, chama á clase "ProfileDB" para gardar a solicitude de amizade.
     * En todo caso, refresca a información do perfil chamando a
     * "reloadProfile".
     *
     * @param profileName
     * @throws tacebook.persistence.PersistenceException
     */
    public void newFriendshipRequest(String profileName) throws PersistenceException {

        // session profile = quiene envia la solicitud = usuario A
        // shown profile = quien recibe la solicitud de amistad = usuario B
        boolean exists = false;

        //comprueba que el perfil del shownprofile existe
        if (ProfileDB.findByName(profileName) != null) {

            //obtiene los amigos del A
            ArrayList<Profile> friends = sessionProfile.getFriends();
            //obtiene las solicitudes de amistad de A
            ArrayList<Profile> pendingRequests = sessionProfile.getFriendshipRequest();
            //obtiene las solicitudes de amistad de B (el futuro amigo)
            ArrayList<Profile> pendingFutureFriendRequests = shownProfile.getFriendshipRequest();

            //si B ya es amigo de A
            for (Profile friend : friends) {
                if (friend.getName().equals(profileName)) {
                    exists = true;
                    break;
                }
            }
            //si B esta en la lista de solicitudes de amistad de A
            for (Profile request : pendingRequests) {
                if (request.getName().equals(profileName)) {
                    exists = true;
                    break;
                }
            }

            //si A esta en la lista de solicitudes de amistad de B
            for (Profile request : pendingFutureFriendRequests) {
                if (request.getName().equals(shownProfile)) {
                    exists = true;
                    break;
                }
            }

            // si ningun caso anterior se cumple, guarda la solicitud de amistad
            if (!exists) {
                ProfileDB.saveFriendshipRequest(shownProfile, sessionProfile);
            }
        }

        //en cualquier caso, recarga el perfil
        reloadProfile();

    }

    /**
     * Chama á clase "ProfileDB" para borrar a solicitude de amizade e gravar a
     * amizade entre o perfil de orixe e o perfil da sesión. Despois chama ao
     * método "reloadProfile" para refrescar a información do perfil.
     *
     * TODO: QUIEN ES EL PERFIL DE ORIGEN Y QUIEN EL PERFIL DE SESION?
     *
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public void acceptFriendshipRequest(Profile sourceProfile) throws PersistenceException {

        ProfileDB.removeFriendshipRequest(shownProfile, sourceProfile);

        ProfileDB.saveFriendship(shownProfile, sourceProfile);

        //recarga el perfil
        reloadProfile();
    }

    /**
     * Chama á clase "ProfileDB" para borrar a solicitude de amizade. Despois
     * chama ao método "reloadProfile" para refrescar a información do perfil.
     *
     * @param sourceProfile
     * @throws tacebook.persistence.PersistenceException
     */
    public void rejectFriendshipRequest(Profile sourceProfile) throws PersistenceException {

        //elimina la solicitud de amistad
        ProfileDB.removeFriendshipRequest(shownProfile, sourceProfile);

        //recarga el perfil
        reloadProfile();
    }

    /**
     * Crea un novo obxecto "Message", chama á clase "MessageDB" para gardalo e
     * chama ao método "reloadProfile" para refrescar a información do perfil.
     *
     * @param destProfile
     * @param text
     * @throws tacebook.persistence.PersistenceException
     */
    public void newMessage(Profile destProfile, String text) throws PersistenceException {
        // public Message(int id, String text, boolean read, Profile destProfile, Profile sourceProfile) {
        // id del mensaje = cantidad de mensajes del destinatario
        Message message = new Message(destProfile.getMessages().size(), text, false, destProfile, shownProfile);

        // metodo que añade al inicio del arraylist
        MessageDB.save(message);

        //recarga el perfil
        reloadProfile();
    }

    /**
     * Chama á clase "MessageDB" para borrar a mensaxe e chama ao método
     * "reloadProfile" para refrescar a información do perfil.
     *
     * @param message
     * @throws tacebook.persistence.PersistenceException
     */
    public void deleteMessage(Message message) throws PersistenceException {
        MessageDB.remove(message);

        //recarga el perfil
        reloadProfile();
    }

    /**
     * Cambia o valor do atributo "read" da mensaxe e true, chama á clase
     * "MessageDB" para actualizar a mensaxe e chama ao método "reloadProfile"
     * para refrescar a información do perfil.
     *
     * @param message
     * @throws tacebook.persistence.PersistenceException
     */
    public void markMessageAsRead(Message message) throws PersistenceException {

        message.setRead(true);
        MessageDB.update(message);

        //recarga el perfil
        reloadProfile();
    }

    /**
     * Cambia o valor do atributo "read" da mensaxe e true, chama á clase
     * "MessageDB" para actualizar a mensaxe e chama ao método "newMessage" para
     * enviar a mensaxe de resposta e recargar o perfil.
     *
     * @param message
     * @param text
     * @throws tacebook.persistence.PersistenceException
     */
    public void replyMessage(Message message, String text) throws PersistenceException {

        // message = original message object        
        // text = text for reply
        message.setRead(true);
        MessageDB.update(message);

        // la repuesta va dirigida al que envio el previo mensaje
        newMessage(message.getSourceProfile(), text);

        //recarga el perfil
        reloadProfile();
    }
}
