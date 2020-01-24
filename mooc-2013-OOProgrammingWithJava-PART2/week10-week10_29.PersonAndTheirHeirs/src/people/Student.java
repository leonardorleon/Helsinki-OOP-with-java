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
public class Student extends Person{
    
    private int credits;
    
    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;       //credits are initialized at zero
    }
    
    public void study(){
        this.credits++;
    }    
    
    public int credits(){
        return this.credits;
    }

    @Override
    public String toString() {
        String toBeReturned = "";
        toBeReturned += super.getName();
        toBeReturned += "\n";
        toBeReturned += "  " + super.getAddress();
        toBeReturned += "\n";
        toBeReturned += "  credits " + this.credits();
        return toBeReturned;
    }
    
    
}
