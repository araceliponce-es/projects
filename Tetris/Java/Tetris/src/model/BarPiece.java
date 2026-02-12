/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Square;
import model.Piece;
import model.Game;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author daw1al13
 */
public class BarPiece extends Piece {

    private Color color = Color.CYAN;

    public BarPiece(Game game) {
        this.game = game;
        squares[0] = new Square(Game.MAX_X / 2, 0, color, game);
        squares[1] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, color, game);
        squares[2] = new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, color, game);
        squares[3] = new Square(Game.MAX_X / 2, 3 * Game.SQUARE_SIDE, color, game);
    }

    @Override
    public boolean rotate() {
        boolean canRotate = false;
        //Si el bloque esta en la posicion indicada en el if siginifica que esta
        //en la posicion 0
        if (squares[0].getY() == squares[1].getY() - Game.SQUARE_SIDE) {
            //Se resorre los cuadrado
            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[1].getX(), squares[1].getY())
                    && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2, squares[3].getY() - Game.SQUARE_SIDE * 2)) {
                //Dice que puede rotar y rota todos
                canRotate = true;
                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);
                squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);
            }
            //Posicion 1
        } else if (squares[0].getX() == squares[1].getX() - Game.SQUARE_SIDE) {
            //Se resorre los cuadrado
            if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[1].getX(), squares[1].getY())
                    && game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE*2, squares[3].getY() + Game.SQUARE_SIDE*2)) {
                //Dice que puede rotar y rota todos
                canRotate = true;
                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE*2);
                squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE*2);

            }
        }
        return canRotate;
    }
}
