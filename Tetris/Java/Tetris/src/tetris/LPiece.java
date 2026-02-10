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
    private int rotationIndex = 0;

    public LPiece(Game game) {
        this.game = game;

        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, color, game);
        squares[1] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, color, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE, color, game);
        squares[3] = new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, color, game);
    }

    @Override
    public boolean rotate() {

        // en cada posicion, cada cuadrado tiene una longitud a moverse
        int[][][] norotations = {
            {{1, 0}, {1, 1}, {1, 2}, {2, 2}}, // posicion 0
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}}, // posicion 1
            {{1, 2}, {1, 1}, {1, 0}, {0, 0}}, // posicion 2
            {{2, 1}, {1, 1}, {0, 1}, {0, 2}}};  // posicion 3

        //posiciones relativas a su posicion anterior
        int[][][] rotations = {
            {{1, 0}, {1, 1}, {1, 2}, {2, 2}}, // posicion 0
            {{-1, 1}, {0, 0}, {1, -1}, {0, -2}}, // posicion 1
            {{1, 2}, {1, 1}, {1, 0}, {0, 0}}, // posicion 2 pendiente
            {{2, 1}, {1, 1}, {0, 1}, {0, 2}}};  // posicion 3 ...
        // int rotationIndex = 0;

        int nextRotation = (rotationIndex + 1) % 4;
        boolean canRotate = true;

        // revisa en todos sus cuadrados, si la futura posicion es valida
        for (int i = 0; i < squares.length; i++) {
            int newX = squares[1].getX() + rotations[nextRotation][i][0] * Game.SQUARE_SIDE;
            int newY = squares[1].getY() + rotations[nextRotation][i][1] * Game.SQUARE_SIDE;
            //si en algun caso no es validposition, sale del loop. nopuede rotar
            if (!game.isValidPosition(newX, newY)) {
                canRotate = false;
                break;
            }
        }


        // rota todos los cuadrados si es válido
        if (canRotate) {
            for (int i = 0; i < squares.length; i++) {
                System.out.println("cuadrado " + i);
                System.out.println(squares[i].getCoordinates());
                System.out.println("rotara en x " + rotations[nextRotation][i][0]);
                System.out.println("rotara en y " + rotations[nextRotation][i][1]);
                System.out.println("=");
                System.out.println(squares[i].getCoordinates());
                
                squares[i].setX(squares[i].getX() + rotations[nextRotation][i][0] * Game.SQUARE_SIDE);
                squares[i].setY(squares[i].getY() + rotations[nextRotation][i][1] * Game.SQUARE_SIDE);
            }
            rotationIndex = nextRotation;
        }

        return canRotate;

//        boolean canRotate = false;
//        int countPiececanRotate = 0;
//        //Si el bloque esta en la posicion indicada en el if siginifica que esta
//        //en la posicion 0
//        if (squares[1].getY() == squares[0].getY() + Game.SQUARE_SIDE) {
//            //Se resorre los cuadrado
//            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
//                    && game.isValidPosition(squares[1].getX(), squares[1].getY())
//                    && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
//                    && game.isValidPosition(squares[3].getX(), squares[3].getY() - Game.SQUARE_SIDE * 2)) 
//            {
//                
//                canRotate = true;
//                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
//                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
//                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
//                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
//                squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);
//            }
//        }
//        return canRotate;
    }

}
