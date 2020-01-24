/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

/**
 *
 * @author leonardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string = null;
        if (string == null){
            System.out.println("it identifies that it's null");
        } else{
            System.out.println("it doesn't work");
        }
        
        
        String longString = "qwertyuiopasdfghjkl;zxcvbnmpoiuytrewq;lkjhgfdsamnbvcxz";
        Person testPerson = new Person(null, 121);
        
//        Calculator calcTest = new Calculator();
//        calcTest.binomialCoefficient(1, 2);
        
    }
    
}
