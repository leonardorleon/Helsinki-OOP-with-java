/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class Farm implements Alive{
    
    private Barn barn;
    private List<Cow> cowHerd;
    private String owner;
    
    public Farm(String owner, Barn barn){
        this.barn = barn;
        this.owner = owner;
        this.cowHerd = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public List<Cow> getCowHerd() {
        return cowHerd;
    }

    public Barn getBarn() {
        return barn;
    }
    
    public void addCow(Cow cow){
        cowHerd.add(cow);
    }
    
    public void manageCows(){
        barn.takeCareOf(cowHerd);
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        barn.installMilkingRobot(milkingRobot);
    }
    
    
    @Override
    public void liveHour() {
        //living an hour in the farm, makes all cows live an hout (produce milk)
        for (Cow cow : cowHerd){
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        String toBeReturned = "Farm owner: " + getOwner() + "\n";
        toBeReturned += "Barn bulk tank: " + barn.toString() + "\n";
        
        if (cowHerd.isEmpty()){
            toBeReturned += "No cows.";
        } else {
            toBeReturned += "Animals:\n";
            for (Cow cow : cowHerd){
                toBeReturned += "        " + cow.toString() + "\n";
            }
        }
        return toBeReturned;
    }
}
