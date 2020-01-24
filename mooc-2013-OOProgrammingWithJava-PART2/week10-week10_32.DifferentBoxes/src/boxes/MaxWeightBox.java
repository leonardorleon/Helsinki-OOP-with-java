/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class MaxWeightBox extends Box{
    
    private final int maxWeight;
    private int currentWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight){
        this.maxWeight = maxWeight;
        this.currentWeight = 0;     //box starts empty
        this.things = new ArrayList<Thing>();
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public void add(Thing thing) {
        //things are only added if they do not pass the max weight
        if (thing.getWeight()+getCurrentWeight() <=  getMaxWeight()){
            things.add(thing);
            currentWeight += thing.getWeight();
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
    
}
