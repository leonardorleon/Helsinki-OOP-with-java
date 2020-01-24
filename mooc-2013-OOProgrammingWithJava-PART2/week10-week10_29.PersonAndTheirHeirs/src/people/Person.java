/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author leonardo
 */
public class Person {
    
    private String name;
    private String address;
    
    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String toBeReturned = "";
        toBeReturned += name;
        toBeReturned += "\n";
        toBeReturned += "  " + address;
        
        return toBeReturned;
    }
    
    
}
