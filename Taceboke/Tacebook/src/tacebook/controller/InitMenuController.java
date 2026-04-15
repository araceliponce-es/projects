/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.controller;

import tacebook.model.Profile;
import tacebook.persistence.PersistenceException;
import tacebook.view.InitMenuView;
import tacebook.persistence.ProfileDB;
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
     * Controlador hasta la fase 2
     */
    public InitMenuController() {

        myView = new InitMenuView(this);
    }

    /**
     * Controlador de la fase 3 en adelante, como estamos en la fae 2 da errores
     *
     * @param textMode
     */
//    public InitMenuController(boolean textMode) {
//        this.textMode = textMode;
//        if (textMode) {
//            this.myView = new TextInitMenuView(this);
//        } else {
//            this.myView = new GUIInitMenuView(this);
//        }
//    }
    /**
     * Método que creará un controlador e invocará al método "init"
     *
     * @param args
     */
    public static void main(String[] args) {

        InitMenuController controller = new InitMenuController();
        controller.init();

    }

    public static void addDemoUsers() throws PersistenceException {
        try {
            Profile uno = new Profile("a", "123", "status");
            Profile dos = new Profile("b", "123", "456");
            Profile tres = new Profile("c", "123", "789");
            ProfileDB.save(uno);
            ProfileDB.save(dos);
            ProfileDB.save(tres);
        } catch (PersistenceException e) {
            System.out.println(e);
        }

    }

    /**
     * Método que llama al método "showLoginMenu" hasta que devuelva true,
     * inicia el tacebook hasta que el usuario salga
     */
    private void init() {

        //SOLO temporal, con usuarios y datos temporales
        System.out.println("hay usuarios temporales");
        try {
            InitMenuController.addDemoUsers();
        } catch (PersistenceException ex) {
            System.getLogger(InitMenuController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

//muestra el menu de loginMenu hasta que este retorne false
        while (!myView.showLoginMenu()) {
            myView.showLoginMenu();
        }

    }

    /**
     * Método que inicia sesión en el tacebook comprobando que el nombre y la
     * contraseña introducidos son correctos (existen en la BD), si no existen
     * mostrará un error, si existen abrirá la sesión del perfil introducido
     *
     * @param name
     * @param password
     */
    public void login(String name, String password) {
        try {
            Profile p = ProfileDB.findByNameAndPassword(name, password, 0);
            if (p == null) {
                myView.showLoginErrorMessage();
            } else {
                new ProfileController().openSession(p);
            }
        } catch (PersistenceException ex) {
            System.getLogger(InitMenuController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
     * @param name
     * @param password
     * @param status
     */
    public void createProfile(String name, String password, String status) {
        try {
            // Comprobamos que no existe un perfil con ese nombre
            System.out.println("Ping");
            if (ProfileDB.findByName(name, 0) == null) {
                // creamos y guardamos el perfil
                Profile nuevoPerfil = new Profile(name, password, status);
                ProfileDB.save(nuevoPerfil);
                ProfileController profileController = new ProfileController();
                profileController.openSession(nuevoPerfil);
            }
        } catch (PersistenceException ex) {
            System.getLogger(InitMenuController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    //Método que necestia la implementación de métodos para las vistas
    //private void proccessPersistenceException(PersistenceException ex){}

}
