/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1;

import java.util.ArrayList;

/**
 * Clase que implementa el estado de una partida de ahorcado, hará referencia a
 * la clase de la palabra oculta y almacenará y mostrará las letras probadas que
 * no estén en la palabra
 *
 * @author Araceli,Diego,Óscar
 */
public class HangMan {

    /**
     * Constante que define el máximo de fallos que puede tener el usuario antes
     * de perder
     */
    public static final int MAX_FAILS = 6;

    /**
     * Objeto que referencia a la clase HiddenWord para usar sus métodos
     */
    private HiddenWord hiddenWord;

    /**
     * ArrayList que almacena las letras que se probaron y que no están en la
     * palabra secreta
     */
    private ArrayList<Character> fails = new ArrayList();

    /**
     * Constructor que recibe un string con la palabra secreta e inicializa el
     * hiddenWord con ella
     *
     * @param palabra
     */
    public HangMan(String palabra) {
        hiddenWord = new HiddenWord(palabra);
    }

    /**
     * Método que obtiene las letras falladas del ArrayList de fallos
     *
     * @return Caracteres que no están en la palabra
     */
    public ArrayList<Character> getFails() {
        return fails;
    }

    /**
     * Método que muestra por pantalla las letras del ArrayList
     *
     * @return Un string con todas las letras falladas separadas con un espacio
     */
    public String getStringFails() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fails.size(); i++) {
            sb.append(fails.get(i)).append(" ");
        }
        return sb.toString();
    }

    /**
     * Método que llama al método show de hiddenWord para devolver la palabra
     * secreta con guiones en los caracteres no acertados
     *
     * @return La palabra secreta con guiones en los caracteres no acertados
     */
    public String showHidenWord() {
        return hiddenWord.show();
    }

    /**
     * Método que llama al método showFullWord para devolver la palabra secreta
     * al completo
     *
     * @return La palara secreta con todas las letras
     */
    public String showFullWord() {
        return hiddenWord.showFullWord();
    }

    /**
     * Método que recibe un caracter y comprueba si pertenece a la palabra
     * secreta, si lo hace se marcarán todas sus apariciones como acertadas y si
     * no, se añade al ArrayList de fallos
     *
     * @param caracter
     */
    public void tryChar(char caracter) {
        if (!hiddenWord.checkChar(caracter)) {
            fails.add(caracter);
        }
    }

    /**
     * Método que comprueba si se terminó la partida porque se adivinó la
     * palabra o porque se llegó al límite de fallos
     *
     * @return Booleano que indica si se terminó la partida o no
     */
    public boolean isGameOver() {
        return hiddenWord.isVisible() || maxFailsExceeded();
    }

    /**
     * Método que comprueba si se llegó al límite de fallos o no
     *
     * @return Booleano que indica si se llegó al límite de fallos o no
     */
    public boolean maxFailsExceeded() {
        boolean excedido;
        excedido = fails.size() == MAX_FAILS;
        return excedido;
    }

}
