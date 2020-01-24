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
public class BulkTank {
    
    private final double capacity;
    private double volume;
    
    public BulkTank(){
        this.capacity = 2000;       //standard tank size is 2000 liters
        this.volume = 0;        //initially the tank is empty
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;       //the tank can also be constructed to satisfy customer specifications
        this.volume = 0;
        
    }
    
    public double getCapacity(){
        return capacity;
    }
    
    public double getVolume(){
        return volume;
    }
    
    public double howMuchFreeSpace(){
        double freeSpace = capacity-volume;     //substract the occupied space from the total space
        return freeSpace;
    }
    
    public void addToTank(double amount){
        if (amount >= howMuchFreeSpace()){
            this.volume+= howMuchFreeSpace();
            return;
        } 
        
        this.volume += amount;
    }
    
    public double getFromTank(double amount){
        if (amount >= this.volume){
            double toReturn = this.volume;
            this.volume = 0;
            return toReturn;
        }
        
        this.volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(getVolume()) + "/" + Math.ceil(getCapacity());
    }
    
    
}
