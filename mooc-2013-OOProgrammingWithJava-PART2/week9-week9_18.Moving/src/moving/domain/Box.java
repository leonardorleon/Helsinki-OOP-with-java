/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Box implements Thing{

    private final int maximumCapacity;
    private final List<Thing> contents;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.contents = new LinkedList<Thing>();
    }

    public boolean addThing(Thing thing) {

        if (thing.getVolume()+this.getVolume() > this.maximumCapacity) {
            return false;
        } else {
            this.contents.add(thing);
            return true;
        }
    }

    @Override
    public int getVolume() {
        int currentVolume = 0;
        for (Thing thing : this.contents){
            currentVolume += thing.getVolume();
        }
        return currentVolume;
    }

    @Override
    public String toString() {
        return this.contents.toString();
    }
}
