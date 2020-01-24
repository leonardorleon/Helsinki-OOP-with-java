/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author leonardo
 */
public class PersonalBoard extends GameOfLifeBoard {

    private Random randomizer = new Random();

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        int i;
        int i1;

        for (i = 0; i < super.getWidth(); i++) {
            for (i1 = 0; i1 < super.getHeight(); i1++) {
                //for each cell, get a random value between 0.0 and 1.0 
                double value = randomizer.nextDouble();
                System.out.println("column: " + i + " row: " + i1);
                super.getBoard()[i][i1] = value <= d;     //if the value is within the given probability, initiate cell
            }
        }

    }

    @Override
    public boolean isAlive(int i, int i1) {
        if (isWithinBoardLimits(i, i1)) {
            return super.getBoard()[i][i1];       //return the status of the cell at location x,y
        }

        return false;       //return false for coordinates outside of the board
    }

    @Override
    public void turnToLiving(int i, int i1) {
        //method that animates the cell in the location x,y
        if (isWithinBoardLimits(i, i1)) {
            super.getBoard()[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        //method that kills the cell at a location x,y
        if (isWithinBoardLimits(i, i1)) {
            super.getBoard()[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        //central cells have 8 neighbors, the ones on the side have 5 and the ones on the corner only have three
        int x;
        int y;
        int neighborsNumber = 0;

        for (x = i - 1; x <= i + 1; x++) {       //loop from one cell before i to one cell after i
            for (y = i1 - 1; y <= i1 + 1; y++) {     //loop from one cell before i1 to one cell after i1
                //System.out.println("("+x+","+y+")");
                if (x==i && y==i1){
                    continue;       //The location of the cell being examined should not be counted
                }
                
                if (isWithinBoardLimits(x, y) && super.getBoard()[x][y]) {        //for the cells that are within board limits, and are alive
                    neighborsNumber++;
                    //System.out.println("number of neighbors:" + neighborsNumber);
                }
            }
        }

        return neighborsNumber;        
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        //a living cell dies if they have less than two living neighbors
        if (getNumberOfLivingNeighbours(i, i1)<2){      
            super.getBoard()[i][i1] = false;
        }
        
        //a living cell lives if they have 2 or 3 living neighbors
        //nothing happens since they stay living if they were alive, but they stay dead if they were dead
        
        //every living cell dies if they have more than 3 living neighbord
        if (getNumberOfLivingNeighbours(i, i1)>3){
            super.getBoard()[i][i1] = false;
        }
        
        //every dead cell is turned back to life if they have exactly three living neighbors
        if (getNumberOfLivingNeighbours(i, i1)==3){
            super.getBoard()[i][i1] = true;
        }
        
    }

    public boolean isWithinBoardLimits(int i, int i1) {
        if (i >= 0 && i < super.getWidth() && i1 >= 0 && i1 < super.getHeight()) {     //make sure it's inside the board limits
            return true;
        }

        return false;       //return false if it's not within the limits
    }

}
