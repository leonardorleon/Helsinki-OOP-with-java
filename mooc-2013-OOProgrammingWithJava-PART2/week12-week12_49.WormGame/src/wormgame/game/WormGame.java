package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.*;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(this.width/2, this.height/2, Direction.DOWN);      //initiate worm in the middle of the screen and its direction as DOWN
        this.apple = createFirstApple() ;      //initiate an apple at a random location inside the limits of the game
        
        addActionListener(this);
        setInitialDelay(2000);

    }
    
    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public Apple createFirstApple(){
        Apple toReturn = new Apple(randomNumber(width), randomNumber(height));        
        while (toReturn.getX() == this.width/2 && toReturn.getY() == this.height/2){
            toReturn = new Apple(randomNumber(width), randomNumber(height));
        }
        
        return toReturn;
    }
    
    private int randomNumber(int maxNumber){
        Random randomizer = new Random();
        int toBeReturned = randomizer.nextInt(maxNumber);       //get a random number between 0 (inclusive) and the parameter given upper bound (exclusive)
        return toBeReturned;
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues){
            return;
        }
        
        this.worm.move();       //move the worm
        
        //if the worm runs into the apple, it grows
        if (this.worm.runsInto(apple)){
            this.worm.grow();
            Apple newApple = new Apple(randomNumber(width), randomNumber(height));
            setApple(newApple);
        }
        
        //if the worm runs into itself, the continues variable is assigned false
        if (this.worm.runsIntoItself()){
            //System.out.println("should stop");
            this.continues = false;
        }
        
        //if the worm runs outside of bounds, the continues variable is assigned false
        for (Piece piece : this.worm.getPieces()){
            if (piece.getX() >= this.width || piece.getY() >= this.height || piece.getX() <= 0 || piece.getY() <= 0){
                this.continues = false;
            }
        }
        
        this.updatable.update();     //call update method
        
        setDelay(1000 / this.worm.getLength());     //the speed of the game increases as the worm gets larger (dividing by a longer worm has a smaller delay)

    }

}
