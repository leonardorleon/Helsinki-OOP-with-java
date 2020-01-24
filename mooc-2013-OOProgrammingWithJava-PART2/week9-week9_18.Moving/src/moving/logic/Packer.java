/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.LinkedList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author leonardo
 */
public class Packer {
    
    private int boxesVolume;
    
    public Packer(int boxesVolume){
        this.boxesVolume = boxesVolume;
    }

    public int getBoxesVolume() {
        return boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things){
        List<Box> packedThings = new LinkedList<Box>();
        //we want to pack things into boxes of the size provided by the constructor parameter
        Box currentBox = createNewBox();    //create the first box we'll use
        for (Thing thing : things){     //so let's iterate through each item            
            
            
            if (currentBox.addThing(thing)){        //if the thing fits the box, it adds it to the box returns true
//                System.out.println("-test line: adding thing to box");
//                System.out.println(currentBox);
            } else if (currentBox.getVolume() > 0){     //in the case the item didn't fit in the box and the box is not empty
//                System.out.println("-test line: item doesn't fit, box needs to be replaced");
                packedThings.add(currentBox);       //add the box to the packedThings list before replacing it with a new box
//                System.out.println("this box: " + currentBox);
                currentBox = createNewBox();        //create a new box and make it the current box
//                System.out.println("New box created");
                currentBox.addThing(thing);
//                System.out.println(currentBox);
                packedThings.add(currentBox);
            }
            
            
            
        }
        
        return packedThings;    //returns a list with boxes
    }
    
    public Box createNewBox(){
        Box newBox = new Box(boxesVolume);
        return newBox;
    }
    
}
