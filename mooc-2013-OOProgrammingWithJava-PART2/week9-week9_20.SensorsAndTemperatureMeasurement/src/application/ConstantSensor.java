/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author leonardo
 */
public class ConstantSensor implements Sensor{
    
    private final int sensorValue;
    
    public ConstantSensor(int value){
        this.sensorValue = value;
    }
    
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {
        //this sensor is always on, so this method does not do anything
    }

    @Override
    public void off() {
        //this sensor is always on, so this method does not do anything
    }

    @Override
    public int measure() {
        return sensorValue;
    }
    
}
