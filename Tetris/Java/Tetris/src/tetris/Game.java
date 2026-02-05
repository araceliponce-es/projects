/*
 * Copyright (C) 2025 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tetris;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

/**
 * Clase que implementa o comportamento do xogo do Tetris
 *
 * @author Profe de Programación
 */
public class Game {

    /**
     * Constante que define o tamaño en pixels do lado dun cadrado
     */
    public final static int SQUARE_SIDE = 20;
    /**
     * Constante que define o valor máximo da coordenada x no panel de cadrados
     */
    public final static int MAX_X = 160;

    /**
     * Constante que define o valor minimo en la cordenada y en el panel de
     * cadradros
     */
    public final static int MAX_Y = 200;

    /**
     * Referenza á peza actual do xogo, que é a única que se pode mover
     */
    private Piece currentPiece;

    /**
     * Referenza á ventá principal do xogo
     */
    private MainWindow mainWindow;

    /**
     * Flag que indica se o xogo está en pausa ou non
     */
    private boolean paused = false;

    /**
     * Número de liñas feitas no xogo
     */
    private int numberOfLines = 0;

    /**
     * ground squares
     */
    private HashMap<String, Square> groundSquares;

    /**
     * @return Referenza á ventá principal do xogo
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * @param mainWindow Ventá principal do xogo a establecer
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return O estado de pausa do xogo
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * @param paused O estado de pausa a establecer
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * @return Número de liñas feitas no xogo
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * @param numberOfLines O número de liñas feitas no xogo
     */
    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     * Construtor da clase, que crea unha primeira peza
     *
     * @param mainWindow Referenza á ventá principal do xogo
     */
    public Game(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.createNewPiece();
        this.groundSquares = new HashMap<String, Square>();
    }

    /**
     * Move a ficha actual á dereita, se o xogo non está pausado
     */
    public void movePieceRight() {
        if (!paused) {
            currentPiece.moveRight();
        }
    }

    /**
     * Move a ficha actual á esquerda, se o xogo non está pausado
     */
    public void movePieceLeft() {
        if (!paused) {
            currentPiece.moveLeft();
        }
    }

    /**
     * Rota a ficha actual, se o xogo non está pausado
     */
    public void rotatePiece() {
        if (!paused) {
            currentPiece.rotate();
        }
    }

    /**
     * Move a peza actual abaixo, se o xogo non está pausado Se a peza choca con
     * algo e xa non pode baixar, pasa a formar parte do chan e créase unha nova
     * peza
     */
    public void movePieceDown() {
        if ((!paused) && (!currentPiece.moveDown())) {
            this.addPieceToGround();
            this.createNewPiece();
            if (this.hitPieceTheGround()) {
                this.mainWindow.showGameOver();
            }
        }
    }

    /**
     * Método que permite saber se unha posición x,y é válida para un cadrado
     *
     * úsase dende os métodos da clase "Piece" que moven a peza para comprobar
     * que cada cadrado vai quedar nunha posición correcta se se move a onde se
     * pretende. Este método só comproba se unha posición x,y onde se quere
     * colocar un cadrado sería válida.
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true se esa posición é válida, se non false
     */
    public boolean isValidPosition(int x, int y) {
        boolean res = true;
        // si x sobrepasa alguno de los maximos o es menor que cero
        // o
        // si y sobrepasa alguno de los maximos o es menor que cero
        // o 
        // si el x y y a evaluar coinciden con un key existente en groundSquares
        // retorna falso
        if (((x == MAX_X) || (x < 0) || (y == MAX_Y) || (y < 0)) || groundSquares.containsKey(x + "," + y)) {
            res = false;
        }

        return res;
    }

    /**
     * Crea unha nova peza e a establece como peza actual do xogo
     */
    private void createNewPiece() {
        Piece piece = new Piece(Game.this);
        this.currentPiece = piece;
    }

    /**
     * Engade unha peza ao chan
     */
    private void addPieceToGround() {
        // Engadimos os cadrados da peza ao chan

        //array donde se almacenan los squares de currentPiece
        Square squares[] = currentPiece.getSquares();
        for (int j = 0; j < squares.length; j++) {
            //obtiene las coordenadas de cada square
            String coordinates = squares[j].getCoordinates();
            //coloca cada square dentro de groundSquares. coordenadas seran el id
            this.groundSquares.put(coordinates, squares[j]);
            System.out.println(groundSquares.size()); //verifica que sí se agregan squares al piso
            System.out.println("values de groundsquares:");
            for (Square valor : groundSquares.values()) {
                System.out.print("anadiendo--- ");
                System.out.print(valor.getCoordinates() + "  ");
            }

        }

        // Chamamos ao método que borra as liñas do chan que estean completas
        this.deleteCompletedLines();
    }

    /**
     * Se os cadrados que están forman unha liña completa, bórranse eses
     * cadrados do chan e súmase unha nova liña no número de liñas realizadas
     */
    private void deleteCompletedLines() {

        //todo:encontrar el punto mas alto de groundsquares 
        int maxSquares = MAX_X / SQUARE_SIDE; //cantidad max posible de squares en tablero

        //si groundSquares no esta vacio
        if (!groundSquares.isEmpty()) {

            //para almacenar cuantas veces aparece cada Y
            Map<Integer, Integer> contador = new HashMap<>();

            //llena el hashmap con items tipo: key:100, value:8, donde 100(squareY), 8 (apariciones)
            for (String key : groundSquares.keySet()) {
                // divide usando la coma, el segundo valor de las 2 partes obtenidas es y
                int squareY = Integer.parseInt(key.split(",")[1]);
                //le introduces la clave al square si esta existe la suma al contador del hashmap
                contador.put(squareY, contador.getOrDefault(squareY, 0) + 1);
            }
            //Creamos dos variables para saber si tiene que borrar y la linea que borrar
            boolean doDelete = false;
            int lineToDelete = 0;

            for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
                if (entry.getValue() == maxSquares) {
                    doDelete = true;
                    lineToDelete = entry.getKey();

                    //cuando se vuelve true
                    if (doDelete) {

                        //Metodo que se encarga de borrar una linea
                        deleteLine(lineToDelete);

                    }
                }
            }

        }

    }

    /**
     * Borra todos os cadrados que se atopan na liña indicada pola coordenada y,
     * e baixa todos os cadrados que estean situados por enriba unha posición
     * cara abaixo
     *
     * @param y Coordenada y da liña a borrar
     */
    private void deleteLine(int y) {

        
        for (int j = 0; j < MAX_X; j += SQUARE_SIDE) {

            System.out.println("borra");
            System.out.println(j + "," + y);

            //obtiene el Square para obtner el LblSquare a borrar
            Square a = this.groundSquares.get(j + "," + y);
            //borra de la interfaz
            mainWindow.deleteSquare(a.getLblSquare());
            //borra del hashmap  . borra todos los en 0, y   40,y    80,y   .....
            this.groundSquares.remove(j + "," + y);

        }

        for (int j = 0; j < MAX_X; j += SQUARE_SIDE) {
            for (int i = y; i >= 0; i -= SQUARE_SIDE) {
                //obtiene el Square para obtner el LblSquare a borrar
                Square a = this.groundSquares.get(j + "," + i);
                if (a != null) {
                    this.groundSquares.remove(a.getCoordinates());
                    a.setY(i + SQUARE_SIDE);
                    this.groundSquares.put(a.getCoordinates(), a);
                }
            }
            System.out.println("Claves de groundsquares:");
            groundSquares.keySet().forEach(k -> System.out.println("[" + k + "]"));
        }
    }

    /**
     * Comproba se a peza actual choca cos cadrados do chan
     *
     * @return true se a peza actual choca cos cadrados do chan; se non false
     */
    private boolean hitPieceTheGround() {

        // TODO: comprobar se algún cadrado da peza actual está nunha posición 
        // inválida. Este método só se usa cando sae unha nova peza na partida, 
        // porque se ao saír a peza esta xa queda en posición inválida, entón 
        // remata a partida. Como cando unha peza ao aparecer nunca vai saír 
        // do panel, neste método non hai que comprobar que as coordenadas x e 
        // y de cada cadrado superen os límites máximo e mínimo, o que haberá 
        // que facer e comprobar que na posición de cada cadrado da peza non 
        // haxa un cadrado dos que están depositados no chan.
        //encuentra el  mas alto de cada columna o x
        boolean res = false;
        //obtengo los valores de la pieza actual mas altos de altura
        for (Square square : currentPiece.getSquares()) {
            //recorre el maximo de square side que puede tener una ficha
                if (!isValidPosition(square.getX(), square.getY())) {
                    res = true;
                }

            //}
        }
        return res;
    }
}
