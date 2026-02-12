/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

/**
 * Clase controlador del menú de inicio con un atributo de la clase
 * InitMenuView, contiene el main. De momento el main no hace nada
 *
 * @author Araceli,Diego,Oscar
 */
public class InitMenuController {

    InitMenuView myView;

    public InitMenuController() {
        
         myView = new InitMenuView(this);
    }

    /**
     * Método que creará un controlador e invocará al método "init"
     *
     * @param args
     */
    public static void main(String[] args) {

        InitMenuController controller = new InitMenuController();
        controller.init();

    }

    /**
     * Método que llama al método "showLoginMenu" hasta que devuelva true,
     * inicia el tacebook hasta que el usuario salga
     */
    private void init() {
        do {
            myView.showLoginMenu();
        } while (!myView.showLoginMenu());

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
        ProfileController pc = null;
        if (ProfileDB.findByNameAndPassword(name, password, 0) == null) {
            myView.showLoginErrorMessage();
        } else {
            pc.openSession(ProfileDB.findByNameAndPassword(name, password, 0));
           
            
            
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
        Profile nuevoPerfil = new Profile(name, password, status);
        for (Profile perfil : TacebookDB.profiles) {
            if (perfil == nuevoPerfil) {
                System.out.println("Ese nombre ya está en uso, elige otro:");
                myView.showNewNameMenu();
            } else {
                ProfileDB.save(nuevoPerfil);
               
                ProfileController profileController = new ProfileController();
                profileController.openSession(nuevoPerfil);
            }
        }
    }

}
