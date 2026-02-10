/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author daw1al13
 */
public class LPiece extends Piece {

    private Color color = Color.MAGENTA;

    public LPiece(Game game) {
        this.game = game;

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, color, game);
        squares[1] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, color, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE, color, game);
        squares[3] = new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, color, game);
    }

    @Override
    public boolean rotate() {
        boolean canRotate = false;
        int countPiececanRotate = 0;
        //Si el bloque esta en la posicion indicada en el if siginifica que esta
        //en la posicion 0
        if (squares[1].getY() == squares[0].getY() - Game.SQUARE_SIDE) {
            //Se resorre los cuadrado
            if(
                    game.isValidPosition(squares[0].getX()-Game.SQUARE_SIDE,squares[0].getY()-Game.SQUARE_SIDE
                    )&
                     game.isValidPosition(squares[0].getX()-Game.SQUARE_SIDE,squares[0].getY()-Game.SQUARE_SIDE
                     )&{
                
            }

                squares[1] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, color, game);
                squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE, color, game);
                squares[3] = new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, color, game);

            

        }
        return canRotate;
    }

}
