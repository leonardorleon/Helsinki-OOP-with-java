/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author leonardo
 */
public class DrawingBoard extends JPanel implements Updatable{

    private final WormGame wormGame;
    private final int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength){
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        super.setBackground(Color.GRAY);
        
        Worm worm = this.wormGame.getWorm();
        Apple apple = this.wormGame.getApple();
                
        g.setColor(Color.BLACK);        //set color to black to draw the worm
        for (Piece piece : worm.getPieces()){
            g.fill3DRect(piece.getX()*pieceLength, piece.getY()*pieceLength, pieceLength, pieceLength, true);
        }
        
        g.setColor(Color.red);      //set color to red to draw the apple
        g.fillOval(apple.getX()*pieceLength, apple.getY()*pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
    
    
    
}
