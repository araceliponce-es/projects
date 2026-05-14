/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import ahorcado.parte1.ui.GenerateWordException;
import ahorcado.parte1.ui.WordGenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que genera palabras atraves de un archivo
 * @author daw1al13
 */
public class FileWordGenerator implements WordGenerator{
    /**
     * Metodo que genera la palabra aleatoria leyendo un archivo
     * 
     * @return word
     * @throws GenerateWordException 
     */
    @Override
    public String generateWord() throws GenerateWordException {
        try (BufferedReader in = new BufferedReader(new FileReader("palabras.txt"))) {
                String line = "";
                ArrayList<String> words = new ArrayList<>();
                while ((line = in.readLine()) != null) {
                    // recorremos cada palabra individualmente 
                    // el line split lo que hace es que cuando hay un
                    // espacio establece eso como limitador y cuenta como
                    // otra linea entonces cada linea equivale a cada palabra
                    // y asi se crea el array de words
                    words.add(line);
                }
                return words.get(new Random().nextInt(words.size()));
        } catch (IOException e) {
             throw new GenerateWordException("error al obtener palabra "+ e.getMessage(),true);
        }
    }
}
    

