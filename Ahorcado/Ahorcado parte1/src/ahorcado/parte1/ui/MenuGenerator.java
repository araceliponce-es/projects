/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1;

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
            menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            menuGenerator.showGameMenu();
            if (menuGenerator.hangMan.isGameOver() && menuGenerator.hangMan.maxFailsExceeded()) {
                System.out.println("Perdiste, la palabra era: " + menuGenerator.hangMan.showFullWord());
            } else if (menuGenerator.hangMan.isGameOver()) {
                System.out.println("Ganaste, la palabra era: " + menuGenerator.hangMan.showFullWord());
            }
        } while (!menuGenerator.showExitMenu());

    }

    /**
     * Método que "muestra" el menú para generar la palabra secreta, actualmente
     * sólo la genera y la devuelve
     *
     * @return La palabra secreta
     */
    private String showInitMenu() {
        WordGenerator palabraSecr = new WordGenerator();
        return palabraSecr.generateWord();
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
