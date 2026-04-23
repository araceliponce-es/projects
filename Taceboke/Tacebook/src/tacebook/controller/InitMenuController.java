/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.controller;

import tacebook.model.Profile;
import tacebook.persistence.DemoData;
import tacebook.persistence.PersistenceException;
import tacebook.view.InitMenuView;
import tacebook.persistence.ProfileDB;
import tacebook.persistence.TacebookDB;
import tacebook.view.GUIInitMenuView;
import tacebook.view.TextInitMenuView;

/**
 * Clase controlador del menú de inicio con un atributo de la clase
 * InitMenuView, contiene el main. De momento el main no hace nada
 *
 * @author Araceli,Diego,Oscar
 */
public class InitMenuController {

    //Este atributo no tiene get ni set, indica si se activa el modo texto
    private boolean textMode;
    private InitMenuView myView;  

    /**
     * Controlador de la fase 3 en adelante, como estamos en la fae 2 da errores
     *
     * @param textMode
     */
    public InitMenuController(boolean textMode) {
        
        this.textMode = textMode;
        if (textMode) {
            this.myView = new TextInitMenuView(this);
        } else {
            this.myView = new GUIInitMenuView(this);
        }
    }

    /**
     * Método que creará un controlador e invocará al método "init" y obtiene
     * los parametos de la terminal para saber si hay que activar el textMode
     *
     * @param args
     */
    public static void main(String[] args) {
        //Variable activando modo text 
        //todo: actualizar archivos *gui*
        boolean textMode = true;
        // Comprueba que el usuario activa el modo texto por comando
        if (args.length > 0 && args[0].equals("text")) {
            textMode = true;
        }
        InitMenuController controller = new InitMenuController(textMode);
        controller.init();
        TacebookDB.close();

    }

    /**
     * Método que llama al método "showLoginMenu" hasta que devuelva true,
     * inicia el tacebook hasta que el usuario salga
     */
    private void init() {

        try {
            DemoData.load();
        } catch (PersistenceException ex) {
            proccessPersistenceException(ex);
        }

        //muestra el menu de loginMenu en loop
        // hasta que este retorne true
        boolean exit = false;
        while (!exit) {
            exit = myView.showLoginMenu();
        }

    }

    /**
     * Método que inicia sesión en el tacebook comprobando que el nombre y la
     * contraseña introducidos son correctos (existen en la BD), si no existen
     * mostrará un error, si existen abrirá la sesión del perfil introducido
     *
     * @param name Nombre del usuario
     * @param password Contraseña del usuario
     */
    public void login(String name, String password) {
        try {
            Profile p = ProfileDB.findByNameAndPassword(name, password, 0);
            if (p == null) {
                myView.showLoginErrorMessage();
            } else {
                                  new ProfileController(textMode).openSession(p);          
            }
        } catch (PersistenceException ex) {
            proccessPersistenceException(ex);
        }   
    }

    /**
     * Método que registra un nuevo usuario mostrando el menú para registrarse
     */
    public void register() {
        myView.showRegisterMenu();

    }

    /**
     * Método que crea un nuevo perfil comprobando que el nombre no existiera
     * antes (si ya existía pedirá uno nuevo), lo almacena en la BD e inicia
     * sesión con él
     *
     * @param name Nombre del usuario
     * @param password Contraseña del usuario
     * @param status Estado del usuario
     */
    public void createProfile(String name, String password, String status) {
        try {

            //Sout sobra, borrar cuando este método funcione 100 veces de 100
            System.out.println("Ping");
            // Comprobamos que no existe un perfil con ese nombre
            if (ProfileDB.findByName(name, 0) == null) {
                // creamos y guardamos el perfil
                Profile nuevoPerfil = new Profile(name, password, status);
                ProfileDB.save(nuevoPerfil);
                ProfileController profileController = new ProfileController(textMode);
                profileController.openSession(nuevoPerfil);
            }
        } catch (PersistenceException ex) {
            proccessPersistenceException(ex);
        }

    }

    private void proccessPersistenceException(PersistenceException ex) {
        switch (ex.getCode()) {
            case 0:
                myView.showConnectionErrorMessage();
                break;
            case 1:
                myView.showReadErrorMessage();
                break;
            case 2:
                myView.showWriteErrorMessage();
                break;

        }
    }

}
