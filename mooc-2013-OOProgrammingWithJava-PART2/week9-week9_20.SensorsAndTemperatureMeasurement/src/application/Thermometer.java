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
import java.util.Random;

public class Thermometer implements Sensor {

    private String thermometerState;

    public Thermometer() {
        this.thermometerState = "OFF";      //the thermometer is off to begin with
    }

    @Override
    public boolean isOn() {
        if (thermometerState.equals("OFF")) {
            return false;
        }

        return true;
    }

    @Override
    public void on() {
        thermometerState = "ON";
    }

    @Override
    public void off() {
        thermometerState = "OFF";
    }

    @Override
    public int measure() {
        Random randomTemp = new Random();

        if (isOn()) {
            int measuredTemp = -30 + randomTemp.nextInt(61);        //the temperature measured is a random number between -30 and 30
            return measuredTemp;
        }
        
        //if the thermometer is off, throw an IllegalStateException
        throw new IllegalStateException("The thermometer must be ON to measure a temperature");

    }

}
