/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author leonardo
 */
public class Barn {
    
    private BulkTank tank;
    private MilkingRobot milkingRobot;
    
    public Barn(BulkTank tank){
        this.tank = tank;
    }
    
    public BulkTank getBulkTank(){
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.milkingRobot = milkingRobot;       //isntall a milking robot in the barn's slot dedicated for a milking robot
        this.milkingRobot.setBulkTank(tank);        //install the bulk tank of the barn to the milking robot
    }
    
    public void takeCareOf(Cow cow){
        try {
            milkingRobot.milk(cow);     //use the milking robot to milk the cow passed as parameter
        } catch (Exception e) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows){
        for (Cow cow : cows){
            takeCareOf(cow);        //take care of each cow in the cows collection
        }
    }

    @Override
    public String toString() {
        return tank.toString();
    }   
    
}
