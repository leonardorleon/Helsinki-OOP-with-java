/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        return Collections.max(history);        //return the largest value from the history list
    }

    public double minValue() {
        return Collections.min(history);        //return the smallest value in the history list
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double totalSum = 0;

        for (double element : history) {
            totalSum += element;        //add all of the elements on the list
        }

        return totalSum / history.size();       //return the average 
    }
    
    public double greatestFluctuation(){
        if (history.isEmpty() || history.size() == 1){
            return 0;
        }
        
        double biggestFluctuation = 0;
        
        for (int i = 1; i<history.size(); i++){     //start at index 1 so we can compare to previous index
            double fluctuation = Math.abs(history.get(i) - history.get(i-1));     //get the change from the current index and the previous index
            if (fluctuation > biggestFluctuation){
                biggestFluctuation = fluctuation;       //if the current calculated fluctuation is greater than the biggest so far, replace it
            }
        }
        
        return biggestFluctuation;
    }
    
    public double variance(){
        //variance is given by 1/(n-1)*sum(yi - yavg)^2
        if (history.isEmpty() || history.size() == 1){
            return 0;
        }
        
        double numerator = 0;
        double denominator = history.size() - 1;
        double avg = this.average();
        
        for (double situation : history){
            double toBeSquared = situation - avg;
            numerator += Math.pow(toBeSquared, 2);
        }
        
        return numerator/denominator;
    }
}
