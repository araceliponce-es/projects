/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1.ui;

/**
 * Subclase de Exception que arroja una excepción cuando no se puede generar la
 * palabra, tiene un atributo para indicar cuándo hay que hacer visible el
 * mensaje de la excepción
 *
 * @author Araceli,Diego,Oscar
 */
public class GenerateWordException extends Exception {

    private boolean visible;

    /**
     * Obtiene si hay que mostrar el mensaje de la excepción o no
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Establece si hay que mostrar el mensaje de la excepción o no
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Constructor que recibe el valor del atributo y un string para llamar a la
     * superclase
     *
     * @param message
     * @param visible
     */
    public GenerateWordException(String message, boolean visible) {
        super(message);
        this.visible = visible;
    }

}
