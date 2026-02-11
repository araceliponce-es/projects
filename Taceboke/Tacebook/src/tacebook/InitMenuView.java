/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook;

import java.util.Scanner;

/**
 * Clase que muestra las opciones del menú inical y recoge los datos
 * introducidos.
 *
 * @author Araceli,Diego,Oscar
 */
public class InitMenuView {

    InitMenuController myController = new InitMenuController();

    /**
     * muestra el menu de inicio de sesion
     * 
     * menu tiene 3 opciones : login, signup, escape
     * 
     * si quiere iniciar sesion o registrarse llama a myController
     * 
     * @return true si usuario quiere salir de app
     */
    public boolean showLoginMenu() {
        System.out.println("¿Iniciar sesión(1), registrarse(2) o salir(3)?");
        Scanner scan=new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1:
                System.out.println("Escribe tu nombre de usuario: ");
                String name=scan.nextLine();
                System.out.println("Escribe tu contraseña: ");
                String password=scan.nextLine();
                myController.login(name, password);
                break;
            case 2:
                myController.register();
                break;
            case 3:
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * muestra mensaje en caso de error en login
     */
    public void showLoginErrorMessage() {
        System.out.println("Usuario y contraseña incorrectos, probablemente sólo uno esté mal, pero no te voy a decir cuál");
    }

    /**
     * muestra el menu de registro
     * 
     * le pide: nombre de usuario, contraseña y repetir contraseña
     * 
     * si provee la informacion llama a myController
     * 
     * @return
     */
    public void showRegisterMenu() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Escribe un nombre de usuario:");
        String name=scan.nextLine();
        System.out.println("Escribe una contraseña:");
        String contraseña=scan.nextLine();
        System.out.println("Escríbela otra vez, que no me quedó clara");
        String segundaContraseña=scan.nextLine();
        if(contraseña.equals(segundaContraseña)){
            String password=segundaContraseña;
            System.out.println("Dime el estado de tu perfil:");
            String status=scan.nextLine();
            myController.createProfile(name, password, status);
        }else{
            System.out.println("Las contraseñas no coinciden");
        } 
    }

    /**
     * muestra el menu para cambiar nombre , porque el que coloco antes ya estaba en uso
     * 
     * @return el nuevo nombre introducido
     */
    public String showNewNameMenu() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Nombe de usuario no disponible, por favor introduce uno nuevo:");
        String newName=scan.nextLine();
        return newName;
    }

}
