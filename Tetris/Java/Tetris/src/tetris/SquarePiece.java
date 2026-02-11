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
public class SquarePiece extends Piece {
    
    private Color color = Color.RED;
    
    public SquarePiece(Game game) {
        this.game = game;
        squares[0] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0,color, game);
        squares[1] = new Square(Game.MAX_X / 2, 0, color, game);
        squares[2] = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, color, game);
        squares[3] = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, color, game);
    }
    
    /**
     * Metodo sobrescrito que como no rota devuelve true
     * @return 
     */
    @Override
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }
    
}
