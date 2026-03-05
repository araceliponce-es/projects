/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ahorcado.parte1.ui;

/**
 * Interfaz que implementa el método para generar la palabra secreta
 *
 * @author Araceli,Diego,Oscar
 */
public interface WordGenerator {

    /**
     * Método que genera la palabra secreta
     *
     * @return La palabra secreta
     * @throws GenerateWordException
     */
    public String generateWord() throws GenerateWordException;

}
