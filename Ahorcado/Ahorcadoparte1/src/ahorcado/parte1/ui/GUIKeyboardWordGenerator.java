/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1.ui;

import javax.swing.JOptionPane;
import javax.swing.text.View;



/**
 *
 * @author daw1al13
 */
public class GUIKeyboardWordGenerator implements WordGenerator {
    private String palabraSecret;
    
    @Override
    public String generateWord() throws GenerateWordException {
        String seleccion = JOptionPane.showInputDialog(
                null,"Introduce la palabra secreta",
                "Palabra Secreta",
                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
        return seleccion;
    }

    public GUIKeyboardWordGenerator(String palabraSecret) {
        this.palabraSecret = palabraSecret;
    }
}
