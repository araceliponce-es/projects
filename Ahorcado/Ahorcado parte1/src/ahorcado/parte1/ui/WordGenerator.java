/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1;

/**
 * Clase que "genera" la palabra escogiendo una aleatoria dentro de un array de
 * palabras
 *
 * @author Araceli,Diego,Óscar
 */
public class WordGenerator {

    /**
     * Array de strings que almacena las posibles palabras secretas
     */
    private String[] seleccionPalabras = new String[5];

    /**
     * Método que guarda unas palabras en el array, genera un número aleatorio
     * dentro de la longitud del array y devuelve la palabra escogida
     *
     * @return La palabra secrerta que hay que adivinar
     */
    public String generateWord() {
        seleccionPalabras[0] = "Guacamole";
        seleccionPalabras[1] = "Aguacate";
        seleccionPalabras[2] = "Cilantro";
        seleccionPalabras[3] = "Jalapeño";
        seleccionPalabras[4] = "Cebolla";
        int escogida = new java.util.Random().nextInt(5);
        String palabra = seleccionPalabras[escogida];
        return palabra;
    }

}
