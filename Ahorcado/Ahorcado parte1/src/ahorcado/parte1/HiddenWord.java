/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado.parte1;

import java.util.Scanner;

/**
 * Clase que implementa una palabra a adivinar y se encargará de comprobar que
 * las letras introducidas están o no en la palabra, de mostrar la palabra sin
 * adivinar y de mostrar la palabra completa una vez termine el juego
 *
 * @author Araceli,Diego,Óscar
 */
public class HiddenWord {

    /**
     * Array de caracteres que almacenará los caracteres de la palabra secreta
     */
    private char[] characters;

    /**
     * Array de booleanos que almacenará true en la posición donde se acierten
     * los caracters de la palabra y false cuando no
     */
    private boolean[] hits;

    /**
     * Obtiene los caracteres de la palabra para el array
     *
     * @return
     */
    public char[] getCharacters() {
        return characters;
    }

    /**
     * Establece los caracteres de la palabra para el array
     *
     * @param characters
     */
    public void setCharacters(char[] characters) {
        this.characters = characters;
    }

    /**
     * Obtiene los aciertos y fallos al introducir una letra para intentar
     * adivinar la palabra
     *
     * @return Booleano que indica si aparece la letra o no en la palabra
     */
    public boolean[] getHits() {
        return hits;
    }

    /**
     * Establece los aciertos y fallos al introducir una letra para intentar
     * adivinar la palabra
     *
     * @param hits
     */
    public void setHits(boolean[] hits) {
        this.hits = hits;
    }

    /**
     * Constructor que recibe la palabra secreta como parámetro, la almacena en
     * el array de caracteres e inicializa todos los hits a false
     *
     * @param palabra
     */
    public HiddenWord(String palabra) {
        //Convierte la String de la palabra en caracteres
        characters = palabra.toCharArray();
        hits = new boolean[characters.length];
        for (int i = 0; i < hits.length; i++) {
            hits[i] = false;
        }
    }

    /**
     * Método que comprueba un caracter recibido y marca las posiciones donde
     * aparece en la palabra como true en hits
     *
     * @param caracter
     * @return Booleano que indica si el caracter aparece o no
     */
    public boolean checkChar(char caracter) {
        boolean charFound = false;
        for (int i = 0; i < characters.length; i++) {
            //Pasa los caracteres a minúscula si no lo eran de antes 
            if (Character.toLowerCase(caracter) == Character.toLowerCase(characters[i])) {
                hits[i] = true;
                charFound = true;
            }
        }
        return charFound;
    }

    /**
     * Método que muestra la palabra incompleta, sustituyendo letras sin acertar
     * por guiones
     *
     * @return La palabra secreta con guiones en lugar de las letras no
     * acertadas
     */
    public String show() {
        StringBuilder sb = new StringBuilder();
        //Bucle que añade al sb el caracter si se acertó y un guión si no
        for (int i = 0; i < characters.length; i++) {
            if (hits[i]) {
                sb.append(characters[i]);
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    /**
     * Método que muestra la palabra secreta al completo, se usará cuando
     * termine el juego
     *
     * @return Un string formado con todos los caracteres de la palabra secreta
     */
    public String showFullWord() {
        return new String(characters);
    }

    /**
     * Método que indica si la palabra es completamente visible porque se
     * acertaron todos sus caracteres
     *
     * @return Booleano que indica si el usuario ganó la partida
     */
    public boolean isVisible() {
        boolean acertada = true;
        //Si hay algún hit false no se adivinó la palabra, el bucle busca algún hit que sea false
        for (int i = 0; i < hits.length && acertada; i++) {
            if (!hits[i]) {
                acertada = false;
            }
        }
        return acertada;
    }
}
