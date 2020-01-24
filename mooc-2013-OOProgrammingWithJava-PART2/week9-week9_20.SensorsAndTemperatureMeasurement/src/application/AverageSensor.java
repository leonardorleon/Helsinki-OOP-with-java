/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class AverageSensor implements Sensor{
    
    private List<Sensor> sensorList;
    private List<Integer> allReadings;
    
    public AverageSensor(){
        this.sensorList = new ArrayList<Sensor>();
        this.allReadings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional){
        
        if (!sensorList.contains(additional)){
            sensorList.add(additional);     //if the sensor is not already on the list, it is added.
        } else{
            System.out.println("Sensor is already on the list");
        }
        
    }
    
    public List<Integer> readings(){
        return allReadings;
    }
    
    //testing method
    public List<Sensor> returnList(){
        return sensorList;
    }
    
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensorList){
            if (!sensor.isOn()){
                return false;       //if any of the sensors is off, return false 
            }
        }
        
        return true;        //if none of them were off, return true
    }

    @Override
    public void on() {
        for (Sensor sensor : sensorList){
            sensor.on();        //turn on every sensor in the sensor list
        }
        System.out.println("sensors are on");
    }

    public void off(Sensor sensor) {
        sensor.off();
    }
    
    @Override
    public void off(){
        for (Sensor sensor : sensorList){
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (!isOn()){
            throw new IllegalStateException("The average sensor must be on to perform a reading");      //if the average sensor is not on, throw an illegal state exception
        }
        
        int addedMeasurements = 0;
        for (Sensor sensor : sensorList){
            addedMeasurements += sensor.measure();
        }
        
        int avg = addedMeasurements / sensorList.size();       //the average value of all the measurements
        
        allReadings.add(avg);       //add it to the list of readings
        return avg;         //return the average value
        
    }
    
}
