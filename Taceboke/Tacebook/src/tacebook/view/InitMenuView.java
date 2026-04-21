/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import tacebook.controller.InitMenuController;

/**
 * Clase que muestra las opciones del menú inical y recoge los datos
 * introducidos.
 *
 * @author Araceli,Diego,Oscar
 */
public interface InitMenuView {

    InitMenuController myController;

    /**
     *
     * @param controller
     * @return 
     */
    public InitMenuView(InitMenuController controller) {
        myController = controller;
        return null;
    }

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
    
    //Métodos fase 3 aunque da igual porque esto se volverá una interfaz
    //Debe usarse siempre que el usuario tenga que escribir un número
    private int readNumber(Scanner scanner) {
        boolean numeroIntroducido = false;
        int numero = -1;
        do {
            try {
                System.out.println("Introduce un numerín");
                numero = scanner.nextInt();
                numeroIntroducido = true;
            } catch (NoSuchElementException Nex) {
                System.out.println("Se debe introducir número, si no no arranca");
            } finally {
                scanner.nextLine();
            }
        } while (!numeroIntroducido);
        return numero;
    }

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
