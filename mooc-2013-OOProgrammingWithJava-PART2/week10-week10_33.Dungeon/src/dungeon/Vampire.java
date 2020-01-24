/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author leonardo
 */
public class Vampire implements Movable{

    private int xLocation;
    private int yLocation;
    private Random randomizer;

    public Vampire(int dungeonXLimit, int dungeonYLimit) {
        randomizer = new Random();
        this.xLocation = generateXLocation(dungeonXLimit);
        this.yLocation = generateYLocation(dungeonXLimit);
        if (this.xLocation == 0 && this.yLocation == 0){        //vampires should not start at 0,0
            this.xLocation +=1;
        }
        
    }

    public int generateXLocation(int xLimit) {
        int proposedX = randomizer.nextInt(xLimit);
        return proposedX;
    }

    public int generateYLocation(int yLimit) {
        int proposedY = randomizer.nextInt(yLimit);
        return proposedY;
    }

    public void setXLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void setYLocation(int yLocation) {
        this.yLocation = yLocation;
    }
    
    public int getXLocation() {
        return xLocation;
    }

    public int getYLocation() {
        return yLocation;
    }

    @Override
    public void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return 'v' + " " + getXLocation() + " " + getYLocation();
    }

     

}
