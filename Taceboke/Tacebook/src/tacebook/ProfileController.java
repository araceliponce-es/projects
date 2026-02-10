/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * controlador
 *
 * @author Araceli,Diego,Oscar
 */
public class ProfileController {

    private Profile sessionProfile;
    private ProfileView myView;

    public Profile getSessionProfile() {
        return sessionProfile;
    }

    public void setSessionProfile(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
    }

    public ProfileView getMyView() {
        return myView;
    }

    public void setMyView(ProfileView myView) {
        this.myView = myView;
    }

    /**
     * obtiene el numero de publicaciones a mostrar
     *
     * @return
     */
    public int getPostsShown() {
        return myView.getPostsShown();
    }

    /**
     * obtiene el perfil de la sesion usando ProfileDB
     *
     * @param db
     */
    public void reloadProfile() {
        ProfileDB.update(sessionProfile);
    }

    /**
     * Abre unha sesión con un perfil, almacenando o obxecto 
     * "sessionProfile" no seu atributo e chamando ao método "showProfileMenu()" 
     * do obxecto vista.
     * 
     * almacenando el objeto "sessionProfile" recibido como abributp y llama a show profile menu
     *
     * openSession() ≠ login solo recibe un perfil válido y lo usa como el
     * perfil actual o activo
     *
     * @param sessionProfile
     */
    public void openSession(Profile sessionProfile) {
        this.sessionProfile = sessionProfile;
        myView.showProfileMenu(sessionProfile); //muestra opciones de cambiar de sesion o cerrar sesion

    }

    /**
     * actualiza los datos que se muestran
     *
     * @param newStatus
     */
    public void updateProfileStatus(String newStatus) {
        sessionProfile.setStatus(newStatus);
        ProfileDB.update(sessionProfile);
        reloadProfile();
    }

}
