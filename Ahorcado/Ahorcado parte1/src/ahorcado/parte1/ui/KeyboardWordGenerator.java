/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1.ui;

import java.util.Scanner;

/**
 * Clase que implementa la interfaz que genera palabras, pide la palabra secreta
 * por teclado
 *
 * @author Araceli,Diego,Oscar
 */
public class KeyboardWordGenerator implements WordGenerator {

    /**
     * Método sobreescrito que pide la palabra secreta por teclado, da null si
     * no se ejecuta en terminal.
     *
     *
     * @return @throws GenerateWordException
     */
    @Override
    public String generateWord() throws GenerateWordException {
        StringBuilder sb = new StringBuilder();
        if (System.console() != null) {
            sb.append(System.console().readPassword());
        } else {
            sb.append(new Scanner(System.in).nextLine());
        }
        return sb.toString();
    }

}
