/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author leonardo
 */
public class Piece {

    private final int x;
    private final int y;
    
    public Piece(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece){
        return piece.getX() == this.getX() && piece.getY() == this.getY();
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
    
    
    
}
