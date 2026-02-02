/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1.ui;

/**
 * Clase que implementa la interfaz para generar palabras, "genera" la palabra
 * escogiendo una aleatoria dentro de un array de palabras
 *
 * @author Araceli,Diego,Óscar
 */
public class ArrayWordGenerator implements WordGenerator {

    /**
     * Array de strings que almacena las posibles palabras secretas
     */
    private String[] seleccionPalabras = new String[5];

    /**
     * Método sobreescrito que guarda unas palabras en el array, genera un
     * número aleatorio dentro de la longitud del array y devuelve la palabra
     * escogida
     *
     * @return La palabra secreta que hay que adivinar
     * @throws ahorcado.parte1.ui.GenerateWordException
     */
    @Override
    public String generateWord() throws GenerateWordException {
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
