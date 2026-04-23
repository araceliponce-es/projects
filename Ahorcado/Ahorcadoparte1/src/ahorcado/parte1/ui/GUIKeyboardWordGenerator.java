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

    @Override
    public String generateWord() throws GenerateWordException {
        String seleccion = JOptionPane.showInputDialog(
                null, "Introduce la palabra secreta",
                "Palabra Secreta",
                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante

        if (isValid(seleccion)) {
            //la palabra se obtiene, y debe enviarse
            System.out.println("la palabra valida es: " + seleccion);
            return seleccion;
        }
        return "";
    }

    /**
     * que devolve true só se todas as letras que teña o String que se recibe
     * como parámetro son letras minúsculas , da "a" a "z". Este método usarase
     * dende o código co método
     *
     * @param word
     * @return
     */
    private boolean isValid(String word) {

        boolean res = word != null && word.trim() != null && word.matches("[a-z]*");
        return res;

    }

}
