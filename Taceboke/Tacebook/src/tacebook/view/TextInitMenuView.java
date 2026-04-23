/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import tacebook.controller.InitMenuController;

/**
 * Aquí metemos el código de InitMenuView
 *
 * @author Araceli,Diego,Oscar
 */
public class TextInitMenuView implements InitMenuView {

    InitMenuController myController;

    /**
     * Constructor de la fista en modo texto que recibe como parámetro el
     * controlador
     *
     * @param controller
     */
    public TextInitMenuView(InitMenuController controller) {
        myController = controller;
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
    @Override
    public boolean showLoginMenu() {
        System.out.println("text ¿Iniciar sesión(1), registrarse(2) o salir(3)?");
        Scanner scan = new Scanner(System.in);
        switch (readNumber(scan)) {
            
            case 1:
                System.out.println("Escribe tu nombre de usuario: ");
                String name = scan.nextLine();
                System.out.println("Escribe tu contraseña: ");
                String password = scan.nextLine();
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
    @Override
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
     */
    @Override
    public void showRegisterMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Escribe un nombre de usuario:");

        String name = scan.nextLine();
        System.out.println("Escribe una contraseña:");
        String contraseña = scan.nextLine();
        System.out.println("Escríbela otra vez, que no me quedó clara");
        String segundaContraseña = scan.nextLine();
        if (contraseña.equals(segundaContraseña)) {
            String password = segundaContraseña;
            System.out.println("Dime el estado de tu perfil:");
            String status = scan.nextLine();
            myController.createProfile(name, password, status);

        } else {
            System.out.println("Las contraseñas no coinciden");
        }
    }

    /**
     * muestra el menu para cambiar nombre , porque el que coloco antes ya
     * estaba en uso
     *
     * @return el nuevo nombre introducido
     */
    @Override
    public String showNewNameMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nombe de usuario no disponible, por favor introduce uno nuevo:");
        String newName = scan.nextLine();
        return newName;
    }

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
    @Override
    public void showConnectionErrorMessage() {
        System.out.println("Erro na conexión co almacén de datos!");
    }

    /**
     * Método que debe mostrar un mensaje cuando se porduzca un error en la
     * lectura de datos
     */
    @Override
    public void showReadErrorMessage() {
        System.out.println("Erro na lectura de datos!");
    }

    /**
     * Método que debe mostrar un mensaje cuando se porduzca un error en la
     * escritura de datos
     */
    @Override
    public void showWriteErrorMessage() {
        System.out.println("Erro na escritura dos datos!");
    }

}
