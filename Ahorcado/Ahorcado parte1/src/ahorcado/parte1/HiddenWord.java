/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ahorcado.parte1;

/**
 *
 * @author Araceli,Diego,Óscar
 */
public class HiddenWord {

    private char[] characters = new char[16];
    private boolean[] hits = new boolean[characters.length];

    public char[] getCharacters() {
        return characters;
    }

    public void setCharacters(char[] characters) {
        this.characters = characters;
    }

    public boolean[] getHits() {
        return hits;
    }

    public void setHits(boolean[] hits) {
        this.hits = hits;
    }

    public HiddenWord(String palabra) {
        characters = palabra.toCharArray();
        for (int i = 0; i < hits.length; i++) {
            hits[i] = false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public boolean checkChar(char c) {
        for (int i = 0; i < hits.length; i++) {
            if (c == characters[i]) {
                hits[i] = true;
            }
        }
        return false;
    }

    public String show() {
        for (int i = 0; i < hits.length; i++) {
            if (hits[i] = true) {
                return "" + characters[i];
            } else {
                return "-";
            }
        }
        return "yes";
    }

}
