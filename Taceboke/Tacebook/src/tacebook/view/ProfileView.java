/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import tacebook.model.Profile;

/**
 * vista
 *
 * @author Araceli,Diego,Oscar
 */
public interface ProfileView {

    /**
     * obtiene el numero de posts mostrados
     *
     * @return
     */
    public int getPostsShown();

    /**
     *
     * @param profile
     */
    public void showProfileMenu(Profile profile);

    /**
     * Os métodos que se inclúen a partir de aquí, simplemente mostran mensaxes
     * por pantalla e chámanse dende o controlador para informar ao usuario de
     * circunstancias que poden provocar que unha acción non se poida realizar.
     * Neste caso, que un perfil non se atopou (Úsase cando se quere enviar unha
     * solicitude de amizade). *
     */
    public void showProfileNotFoundMessage();

    /**
     * Informa de que non se pode facer like sobre unha publicación propia. *
     */
    public void showCannotLikeOwnPostMessage();

    /**
     * Informa de que non se pode facer like sobre unha publicación sobre a que
     * xa se fixo like. *
     */
    public void showAlreadyLikedPostMessage();

    /**
     * Informa de que xa tes amizade con ese perfil.
     *
     *
     * @param profileName
     */
    public void showIsAlreadyFriendMessage(String profileName);

    /**
     * Informa de que ese perfil xa ten unha solicitude de amizade contigo.
     *
     *
     * @param profileName
     */
    public void showExistsFrienshipRequestMessage(String profileName);

    /**
     * Informa de que xa tes unha solicitude de amizade con ese perfil.
     *
     *
     * @param profileName
     */
    public void showDuplicateFrienshipRequestMessage(String profileName);

    /**
     * Método que debe mostrar un mensaje cuando se porduzca un error en la
     * conexión con la base de datos
     */
    public void showConnectionErrorMessage();

    /**
     * Método que debe mostrar un mensaje cuando se porduzca un error en la
     * lectura de datos
     */
    public void showReadErrorMessage();

    /**
     * Método que debe mostrar un mensaje cuando se porduzca un error en la
     * escritura de datos
     */
    public void showWriteErrorMessage();

}
