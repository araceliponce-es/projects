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
package model;

import model.Game;
import java.awt.Color;
import java.util.Random;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */
public abstract class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    protected Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    protected Square[] squares = new Square[4];

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Piece() {
    }

    public Square[] getSquares() {
        return squares;
    }

    public void setSquares(Square[] squares) {
        this.squares = squares;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {


           for (Square sq : squares) {
            if (!game.isValidPosition(sq.getX()+ game.SQUARE_SIDE, sq.getY() )) {
                return false;
            }
        }

        // y sera igual al valor mas grande de los 4 squares
        //solo .moveDown() necesita que todos los cuadrados sean validos. usa un counter
        for (int i=0;i<squares.length;i++) {
            squares[i].setX(squares[i].getX()+game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {


           for (Square sq : squares) {
            if (!game.isValidPosition(sq.getX()- game.SQUARE_SIDE, sq.getY() )) {
                return false;
            }
        }

        // y sera igual al valor mas grande de los 4 squares
        //solo .moveDown() necesita que todos los cuadrados sean validos. usa un counter
        for (int i=0;i<squares.length;i++) {
            squares[i].setX(squares[i].getX()-game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {

        for (Square sq : squares) {
            if (!game.isValidPosition(sq.getX(), sq.getY() + game.SQUARE_SIDE)) {
                return false;
            }
        }

        // y sera igual al valor mas grande de los 4 squares
        //solo .moveDown() necesita que todos los cuadrados sean validos. usa un counter
        for (int i=0;i<squares.length;i++) {
            squares[i].setY(squares[i].getY()+game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public abstract boolean rotate();
}
