/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Clase controlador del perfil con un atributo ProfileView y Profile, controla
 * las acciones del menú principal
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileController {

    private Profile sessionProfile;
    private ProfileView myView;

   
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
     * Obtiene el perfil de la sesion usando ProfileDB y muestra su menú
     */
    public void reloadProfile() {
        ProfileDB.update(sessionProfile);
    }

 

    /**
     * Abre una sesión con un perfil y muestra su menú de opciones.
     *
     * @param sessionProfile
     */
    public void openSession(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
        myView.showProfileMenu(sessionProfile); //muestra opciones de cambiar de sesion o cerrar sesion

    }

    /**
     * Actualiza y guarda los datos del perfil, luego recarga el perfil y lo
     * muestra con los datos actualizados.
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
        sessionProfile.setStatus(newStatus);
        ProfileDB.update(sessionProfile);
        reloadProfile();
    }

}
