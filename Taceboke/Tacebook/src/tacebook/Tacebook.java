/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 *
 * clases para las vistas que tendra la aplicacion: InitMenuView, ProfileView
 * clases controladores: InitMenuController e ProfileController
 * @author Araceli,Diego,Oscar
 */
public class Tacebook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TacebookDB dbTacebook = new TacebookDB();
        ProfileDB dbProfiles = new ProfileDB();

        //registrar e iniciar sesion usan las mismas preguntas
        System.out.println("ingresa nombre: ");
        String userName = scan.nextLine();
        System.out.println("ingresa contraseña: ");
        String userPassword = scan.nextLine();

        Profile loggedUser = dbProfiles.findByNameAndPassword(dbTacebook, userName, userPassword, 0);

        if (loggedUser == null) {
            System.out.println("usuario no encontrado en bd");
            System.out.println("puedes registrarte...");

        } else {

            System.out.println("not null");
            Profile model = loggedUser;
            ProfileView view = new ProfileView();
            ProfileController controller = new ProfileController(model, view);

            //actualiza datos del profile
            controller.setProfileName(userName);
            //actualiza la vista
            controller.updateView();
            
            //le muestra opciones como 0:cambiar status, 1: revisar notificaciones, publicar, etc...
        }

       
        //para registrar el nombre no puede ser repetido
        //para registrar debe escribir la misma contraseña 2 veces (repite la contraseña)
        //----------------------------
        //cambiar el estado de perfil
        //cerrar la sesion te envia de regreso al menu inicial
    }

}
