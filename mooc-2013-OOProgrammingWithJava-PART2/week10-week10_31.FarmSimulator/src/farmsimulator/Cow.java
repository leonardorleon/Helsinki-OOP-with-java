/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author leonardo
 */
public class Cow implements Milkable, Alive{
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private String name;
    private double capacity;
    private double availableMilk;
    private final Random randomizer = new Random();
    
    public Cow(){
        this("placeholder");
    }
    
    public Cow(String name){
        //if no parameter is given, name is set to placeholder and it is promptly replaced by a random name. Otherwise, the given parameter is used.
        if (name.equals("placeholder")){
            name = getRandomName();     
        }
        
        this.name = name;
        this.capacity = 15 + randomizer.nextInt(26);        //cow capacity is between 15 and 46
        this.availableMilk = 0;     //cow starts with cero available milk
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }
    
    public double getAmount(){
        return availableMilk;
    }

    @Override
    public String toString() {
        return getName() + " " + Math.ceil(getAmount()) + "/" + Math.ceil(getCapacity());
    }
    
    protected final String getRandomName(){
        int randomNameLocation = randomizer.nextInt(NAMES.length);        //get a random index from 0 to the length of the array 
        String randomName = NAMES[randomNameLocation];      //get the name at the given location
        return randomName;
    }
    
    public double howMuchCapacityLeft(){
        return getCapacity()-getAmount();
    }

    @Override
    public double milk() {
        double toReturn = getAmount();
        availableMilk = 0;
        return toReturn;
    }

    @Override
    public void liveHour() {
        //we simulate 25-30 liters of production per day, as 0.7-2 liters produced every hour the cow lives
        double lowerBound = 0.7;
        double upperBound = 2;
        double milkProduced = lowerBound + (randomizer.nextDouble()*(upperBound-lowerBound));       //add a random percentage of the interval (upper-lower Bounds) to the lower bound
//        System.out.println("milk produced: " + milkProduced + "/capcity left" + howMuchCapacityLeft());
        
        if (milkProduced <= howMuchCapacityLeft()){
            availableMilk += milkProduced;      //if the random amount of milk produced fits the remaining capacity of the cow, add it to its milk amount
        } else{
            availableMilk += howMuchCapacityLeft();     //if the random amount of milk produced does not fit the capacity left, simply fill to capacity
        }
    }
    
}
