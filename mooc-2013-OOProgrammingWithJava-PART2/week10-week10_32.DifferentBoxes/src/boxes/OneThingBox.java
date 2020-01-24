/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author leonardo
 */
public class OneThingBox extends Box{
    
    private Thing oneThing;      //the box can only have one thing, if it already has a thing it cannot be changed

    public OneThingBox(){
        this.oneThing = new Thing("Placeholder");
    }
    
    @Override
    public void add(Thing thing) {
        if (oneThing.getName().equals("Placeholder")){
            this.oneThing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.oneThing.equals(thing);
    }
    
}
