/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado.parte1;

import java.util.ArrayList;

/**
 *
 * @author daw1al11
 */
public class HangMan {
    public static final int MAX_FAILS=6;
    HiddenWord hiddenWord=new HiddenWord("Guacamole");
    private ArrayList<Character> fails=new ArrayList();

    public HangMan(String palabra) {
        hiddenWord=new HiddenWord(palabra);
    }
    
    public ArrayList<Character> getFails(){
        return fails;
    }
    public String getStringFails(){
        String fallos=" ";
        return fallos;
    }
    
    
}
