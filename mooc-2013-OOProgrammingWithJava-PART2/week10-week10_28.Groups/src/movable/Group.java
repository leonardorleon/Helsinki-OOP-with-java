/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Group implements Movable {
    
    private List<Movable> group;
    
    public Group(){
        group = new ArrayList<Movable>();
    }

    @Override
    public String toString() {
        String toBeReturned = "";
        
        for (Movable groupItem : group){
            toBeReturned += groupItem.toString();      //each item's position is added to a string
            toBeReturned += "\n";       //separate each item with a line break
        }
        
        return toBeReturned;
    }
    
    public void addToGroup(Movable movable){
        group.add(movable);     //add new item to the group
    }
    
    @Override
    public void move(int dx, int dy) {
        
        for (Movable groupItem : group){
            groupItem.move(dx, dy);     //move each item in the group by the provided increments
        }
    }
    
}
