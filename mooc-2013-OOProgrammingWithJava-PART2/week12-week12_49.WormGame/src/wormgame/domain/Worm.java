/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author leonardo
 */

/* TODO
-grow() should keep track if it was callled the last time
-move() only calls grow depending on the situation, for example you first take your move 
then do if (length is less than 3) call grow() otherwise, set grow to false (or 0 and 1)
or maybe later it will be if (ate apple) grow()

 */
public class Worm {

    private final int originalX;
    private final int originalY;
    private Direction direction;
    private final List<Piece> pieces;
    private int shouldGrow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));       //add the origin location as a piece for the worm
        this.shouldGrow = 0;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return this.pieces.size();
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {

        switch (getDirection()) {
            case LEFT: {
                //System.out.println("TEST LINE - moving left");                
                Piece currentHead = getWormHead();
                Piece newHead = new Piece(currentHead.getX() - 1, currentHead.getY());        //the new piece is placed to the left of the old head
                this.pieces.add(newHead);       //add the new piece to the list
                break;
            }
            case RIGHT: {
                //System.out.println("TEST LINE - moving right");                
                Piece currentHead = getWormHead();
                Piece newHead = new Piece(currentHead.getX() + 1, currentHead.getY());        //new piece to the right of the old one
                this.pieces.add(newHead);
                break;
            }
            case UP: {
                //System.out.println("TEST LINE - moving up");                
                Piece currentHead = getWormHead();
                Piece newHead = new Piece(currentHead.getX(), currentHead.getY() - 1);        //to move up, substract from Y axis as axis are flipped when drawing
                this.pieces.add(newHead);
                break;
            }
            case DOWN: {
                //System.out.println("TEST LINE - moving down");
                Piece currentHead = getWormHead();
                Piece newHead = new Piece(currentHead.getX(), currentHead.getY() + 1);        //to move down, add one to the Y axis as the vertical axis is flipped when drawing
                this.pieces.add(newHead);
                break;
            }
        }
        
        if (getLength() <= 3){
            this.shouldGrow = 1;        //if the worm is smaller than 3 pieces, it grows until that stage
        }
        
        
        //if grow() was called previously, don't delete the last piece. Otherwise delete it
        if (this.shouldGrow == 1) {
            grow();     //turn off grow after it's grown
        } else {
            this.pieces.remove(getLastPiece());     //if grow is off, remove the last piece of the worm
        }
        
    }

    public void grow() {

        if (this.shouldGrow == 0) {
            this.shouldGrow = 1;        //turn grow ON
        } else {
            this.shouldGrow = 0;        //turn grow OFF
        }

    }

    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : this.pieces) {        //iterate through all the pieces that make the worm
            if (piece.getX() == wormPiece.getX() && piece.getY() == wormPiece.getY()) {
                return true;        //if any piece of the worm runs into the parameter piece, then return true
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (i == j){
                    continue;       //do not look into the case where i=j or the pieces are the same piece
                }
//                System.out.println(this.pieces);
//                System.out.println(this.pieces.get(i) + " compared to " + this.pieces.get(j));
                if (this.pieces.get(i).getX() == this.pieces.get(j).getX() && this.pieces.get(i).getY() == this.pieces.get(j).getY()){      //compare x and y coordinates of piece(i) and piece(j)
                    //System.out.println("runs into itself");
                    return true;        //if one of the pieces runs into any other piece, return true
                }
                
            }
        }
        
        return false;
    }

    private Piece getWormHead() {
        return this.pieces.get(getLength() - 1);
    }

    private Piece getLastPiece() {
        return this.pieces.get(0);
    }
    
    
}
