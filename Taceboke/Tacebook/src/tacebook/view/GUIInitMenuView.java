/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tacebook.view;

import java.awt.GridLayout;
import static java.lang.String.valueOf;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tacebook.controller.InitMenuController;
import static tacebook.view.GUIProfileView.customizePallete;

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
        customizePallete();
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

        JLabel jLabel1 = new JLabel();
        JTextField inputUsuario = new JTextField();

        JLabel jLabel2 = new JLabel();
        JPasswordField inputPassword = new JPasswordField();

        panel.setLayout(new GridLayout(4, 2));

        jLabel1.setText("Nombre de usuario:");
        panel.add(jLabel1);
        panel.add(inputUsuario);

        jLabel2.setText("Contraseña:");
        panel.add(jLabel2);
        panel.add(inputPassword);

// Botones personalizados
        Object[] opciones = {"Login", "Registrar", "Cancelar"};

        int resultado = JOptionPane.showOptionDialog(
                null,
                panel,
                "Menu Inicio de Sesion",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

// Saber qué botón pulsó
        if (resultado == 0) {

            if (inputUsuario.getText().trim().equals("") || valueOf(inputPassword.getPassword()).trim().equals("")) {

                JOptionPane.showMessageDialog(panel, "No puedes dejar ningun campo vacio!!");
                return false;
            }
            String pwd = new String(inputPassword.getPassword());
            System.out.println(pwd);

            //intenta hacer login
            // to-do: hacer 
            myController.login(inputUsuario.getText().trim(), pwd);
            return true;
        } else if (resultado == 1) {
            showRegisterMenu();
            return true;
        } else {
            System.exit(0);
        }
        return false;
    }

    /**
     * muestra mensaje en caso de error en login
     */
    @Override
    public void showLoginErrorMessage() {
        JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrectos, probablemente sólo uno esté mal, pero no te voy a decir cuál");
        showLoginMenu();
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
        boolean exitRegister = false;

        JPanel panel = new JPanel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField inputUsuario = new javax.swing.JTextField();
        JLabel jLabel3 = new javax.swing.JLabel();
        JPasswordField inputPassword = new javax.swing.JPasswordField();
        JLabel jLabel1 = new javax.swing.JLabel();
        JPasswordField inputPasswordNuevo = new javax.swing.JPasswordField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField inputStatus = new javax.swing.JTextField();

        panel.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setText("Nombre de usuario:");
        panel.add(jLabel1);
        panel.add(inputUsuario);

        jLabel2.setText("Contraseña:");
        panel.add(jLabel2);
        panel.add(inputPassword);

        jLabel3.setText("Repite contraseña:");
        panel.add(jLabel3);
        panel.add(inputPasswordNuevo);

        jLabel4.setText("Estado:");
        panel.add(jLabel4);
        panel.add(inputStatus);

        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        while (!exitRegister) {
            int confirmed = JOptionPane.showConfirmDialog(null, panel, "Menu de Registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmed == JOptionPane.CANCEL_OPTION || confirmed == JOptionPane.CLOSED_OPTION) {
                showLoginMenu();
            } else if (inputUsuario.getText().trim().equals("") || valueOf(inputPassword.getPassword()).trim().equals("") || valueOf(inputPassword.getPassword()).trim().equals("") || inputStatus.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(panel, "No puedes dejar ningun campo vacio!!");

            } else if (valueOf(inputPassword.getPassword()).equals(valueOf(inputPasswordNuevo.getPassword()))) {
                myController.createProfile(inputUsuario.getText(), valueOf(inputPassword.getPassword()), inputStatus.getText());
                exitRegister = true;
            } else {
                JOptionPane.showMessageDialog(panel, "Las contraseñasa no coinciden !!");
                System.out.println("ya estas avisado");
            }
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
