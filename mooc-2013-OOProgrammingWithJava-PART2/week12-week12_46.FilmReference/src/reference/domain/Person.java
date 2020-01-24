/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

/**
 *
 * @author leonardo
 */
public class Person {

    private final String name;
    
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    
    
//    @Override
//    public boolean equals(Object obj) {
//        //first check they're the same reference
//        if (this == obj){
//            return true;
//        }
//        
//        //null check
//        if (obj == null){
//            return false;
//        }
//        
//        //type check
//        if (this.getClass() != obj.getClass()){
//            return false;
//        }
//        
//        //type cast
//        Person compared = (Person) obj;
//        
//        return !compared.getName().equals(this.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return this.name.hashCode();
//    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
}
