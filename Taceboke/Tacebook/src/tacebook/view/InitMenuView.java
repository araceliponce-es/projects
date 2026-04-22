/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

/**
 * Clase que muestra las opciones del menú inical y recoge los datos
 * introducidos.
 *
 * @author Araceli,Diego,Oscar
 */
public interface InitMenuView {

    /**
     * muestra el menu de inicio de sesion
     *
     * menu tiene 3 opciones : login, signup, escape
     *
     * si quiere iniciar sesion o registrarse llama a myController
     *
     * @return true si usuario quiere salir de app
     */
    public boolean showLoginMenu();

    /**
     * muestra mensaje en caso de error en login
     */
    public void showLoginErrorMessage();

    /**
     * muestra el menu de registro
     *
     * le pide: nombre de usuario, contraseña y repetir contraseña
     *
     * si provee la informacion llama a myController
     *
     */
    public void showRegisterMenu();

    /**
     * muestra el menu para cambiar nombre , porque el que coloco antes ya
     * estaba en uso
     *
     * @return el nuevo nombre introducido
     */
    public String showNewNameMenu();


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
