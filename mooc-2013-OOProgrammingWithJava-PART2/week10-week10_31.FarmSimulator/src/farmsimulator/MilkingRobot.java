/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author leonardo
 */
public class MilkingRobot {
    
    private BulkTank installedTank;
    
    public MilkingRobot(){
        installedTank = null;       //initially no tank is attached
    }
    
    public BulkTank getBulkTank(){
        return installedTank;
    }
    
    public void setBulkTank(BulkTank tank){
        installedTank = tank;
    }
    
    public void milk(Milkable milkable){
        
        try {
            double toStoreInTank = milkable.milk();
            getBulkTank().addToTank(toStoreInTank);
        } catch(Exception e){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
    
}
