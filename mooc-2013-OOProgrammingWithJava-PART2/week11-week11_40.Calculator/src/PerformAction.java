/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardo
 */
public class PerformAction {
    
    private int result;
    
    public void add(int input){
        result += input;
    }
    
    public void substract(int input){
        result -= input;
    }
    
    public void clear(){
        result = 0;
    }
    
    public int getResult(){
        return result;
    }
    
}
