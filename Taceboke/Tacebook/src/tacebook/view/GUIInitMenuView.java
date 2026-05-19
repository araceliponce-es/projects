/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tacebook.controller.InitMenuController;

/**
 * Aquí metemos el código de InitMenuView
 *
 * @author Araceli,Diego,Oscar
 */
public class GUIInitMenuView implements InitMenuView {

    InitMenuController myController;

    /**
     *
     * @param controller
     */
    public GUIInitMenuView(InitMenuController controller) {
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
        JPanel panel = new JPanel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JPasswordField jPasswordField1 = new javax.swing.JPasswordField();
        JLabel jLabel1 = new javax.swing.JLabel();
        JTextField jTextField2 = new javax.swing.JTextField();
        JButton jBLogin = new javax.swing.JButton();
        JButton jBRegister = new javax.swing.JButton();
        JButton jBexit = new javax.swing.JButton();
        jBexit.setText("Salir");
        jBLogin.setText("Iniciar Sesion");
        jBRegister.setText("Registrarse");
        JButton[] optionButtons = {jBLogin,jBRegister,jBexit};
        
        

        panel.setLayout(new java.awt.GridLayout(3, 2));
        
        jLabel2.setText("jLabel2");
        panel.add(jLabel2);

        panel.add(jTextField1);

        jLabel3.setText("jLabel3");
        panel.add(jLabel3);


        panel.add(jPasswordField1);

        jLabel1.setText("jLabel1");
        panel.add(jLabel1);

        panel.add(jTextField2);
        
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        

        JOptionPane.showInputDialog(null, panel, "prueba", 0, null, optionButtons,null);
          
        
        return false;

//        System.out.println("gui ¿Iniciar sesión(1), registrarse(2) o salir(3)?");
//        Scanner scan = new Scanner(System.in);
//        switch (readNumber(scan)) {
//            case 1:
//
//                System.out.println("Escribe tu nombre de usuario: ");
//                String name = scan.nextLine();
//                System.out.println("Escribe tu contraseña: ");
//                String password = scan.nextLine();
//                myController.login(name, password);
//                break;
//            case 2:
//                myController.register();
//                break;
//            case 3:
//                return true;
//            default:
//                break;
//        }
//        return false;
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
