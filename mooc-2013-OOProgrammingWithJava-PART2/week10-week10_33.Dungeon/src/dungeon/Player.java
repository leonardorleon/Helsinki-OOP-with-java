/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author leonardo
 */
public class Player implements Movable{
    
    private int xLocation;
    private int yLocation;
    private char symbol;
    
    private Player(int xLocation, int yLocation){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.symbol = '@';
    }
    
    public Player(){
        this(0, 0);     //players start ar location 0,0
    }

    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void moveLeft() {
        this.xLocation -= 1;
    }

    @Override
    public void moveRight() {
        this.xLocation += 1;
    }

    @Override
    public void moveUp() {
        this.yLocation -= 1;
    }

    @Override
    public void moveDown() {
        this.yLocation += 1;
    }

    @Override
    public String toString() {
        return symbol + " " + getXLocation() + " " + getYLocation();
    }
    
}
