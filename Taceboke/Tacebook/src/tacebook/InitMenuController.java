/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 *
 * @author Araceli,Diego,Oscar
 */
public class InitMenuController {

    InitMenuView myView;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TacebookDB.getProfiles().add(new Profile("a", "a", "a"));

        //registrar e iniciar sesion usan las mismas preguntas
        System.out.println("ingresa nombre: ");
        String userName = scan.nextLine();
        System.out.println("ingresa contraseña: ");
        String userPassword = scan.nextLine();

        Profile loggedUser = ProfileDB.findByNameAndPassword(userName, userPassword, 0);

        if (loggedUser == null) {
            System.out.println("usuario no encontrado en bd");
            System.out.println("puedes registrarte...");

        } else {

            System.out.println("not null");
            Profile model = loggedUser;
            ProfileView view = new ProfileView();
            ProfileController controller = new ProfileController(model, view);

            //actualiza datos del profile
            controller.updateProfileStatus(userName);

            //le muestra opciones como 0:cambiar status, 1: revisar notificaciones, publicar, etc...
        }

        //para registrar el nombre no puede ser repetido
        //para registrar debe escribir la misma contraseña 2 veces (repite la contraseña)
        //----------------------------
        //cambiar el estado de perfil
        //cerrar la sesion te envia de regreso al menu inicial
    }

    private void init() {
        do {
            myView.showLoginMenu();
        } while (!myView.showLoginMenu());

    }

    public void login(String name, String password) {
        ProfileController pc = null;
        if(ProfileDB.findByNameAndPassword(name, password, 0)==null){
        myView.showLoginErrorMessage();
        }else{
        pc.openSession(ProfileDB.findByNameAndPassword(name, password, 0));
        }
    }

    public void register() {
        myView.showRegisterMenu();
    }

    public void createProfile(String name, String password, String status) {
        Profile nuevoPerfil=new Profile(name, password, status);    
        for(Profile perfil:TacebookDB.profiles){
            if(perfil==nuevoPerfil){
                System.out.println("Ese nombre ya está en uso, elige otro:");
                myView.showNewNameMenu();
            }else{
                ProfileDB.save(nuevoPerfil);
                ProfileController abrirSesion = null;
                abrirSesion.openSession(nuevoPerfil);
            }
        }
    }

}
