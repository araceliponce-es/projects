/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1.ui;

import ahorcado.parte1.model.HangMan;
import java.util.Scanner;

/**
 * Clase que muestra los menús del juego y recoge los datos del usuario
 *
 * @author Araceli,Diego,Óscar
 */
public class MenuGenerator {

    /**
     * Objeto de tipo hangMan que gestionará el funcionamiento de la partida
     */
    private HangMan hangMan;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuGenerator menuGenerator = new MenuGenerator();
        do {
            try {
                menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            } catch (GenerateWordException ex) {
                if (ex.isVisible()) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            menuGenerator.showGameMenu();
            if (menuGenerator.hangMan.isGameOver() && menuGenerator.hangMan.maxFailsExceeded()) {
                System.out.println("Perdiste, la palabra era: " + menuGenerator.hangMan.showFullWord());
            } else if (menuGenerator.hangMan.isGameOver()) {
                System.out.println("Ganaste, la palabra era: " + menuGenerator.hangMan.showFullWord());
            }
        } while (!menuGenerator.showExitMenu());

    }

    /**
     * Método que pregunta al usuario qué modo de juego quiere y muestra el menú
     * para generar la palabra secreta, actualmente sólo hay dos modos de juego
     * y uno no genera ningún menú visible
     *
     * @return La palabra secreta
     * @throws ahorcado.parte1.ui.GenerateWordException
     */
    private String showInitMenu() throws GenerateWordException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Elige el modo de juego:Clásico(1)/Competitivo(2)");
        String eleccion = scan.nextLine();
        if ("1".equalsIgnoreCase(eleccion)) {
            ArrayWordGenerator palabraSecr = new ArrayWordGenerator();
            return palabraSecr.generateWord();
        } else if ("2".equalsIgnoreCase(eleccion)) {
            KeyboardWordGenerator palabraSecr = new KeyboardWordGenerator();
            return palabraSecr.generateWord();
        } else {
            System.out.println("Modo no disponible");
        }
        return null;
    }

    /**
     * Método que muestra el menú del juego en el que se pedirán las letras y se
     * mostrarán los fallos y aciertos, se detendrá si se termina el juego
     */
    private void showGameMenu() {
        Scanner scan = new Scanner(System.in);
        while (!hangMan.isGameOver()) {

            System.out.println("¿Qué letra estará en esta palabra misteriosa?:");
            System.out.println();
            char c = scan.next().charAt(0);
            hangMan.tryChar(c);
            System.out.println();
            System.out.println(hangMan.showHidenWord());
            System.out.println("Letras falladas: " + hangMan.getStringFails());
        }

    }

    /**
     * Método que muestra el menú de fin de partida y pregunta al usuario si
     * quiere jugar otra vez
     *
     * @return Booleano que indica si el usuario quiere jugar otra vez o no
     */
    private boolean showExitMenu() {
        if (hangMan.isGameOver()) {
            System.out.println("¿Quieres jugar otra vez?(s/n)");
            Scanner scan = new Scanner(System.in);
            String respuesta = scan.nextLine();
            return !("s".equalsIgnoreCase(respuesta));
        } else {
            return false;
        }
    }

}
