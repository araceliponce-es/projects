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

    public void showLoginErrorMessage() {
    }

    public void showRegisterMenu() {
    }

    public String showNewNameMenu() {
        return null;
    }

}
