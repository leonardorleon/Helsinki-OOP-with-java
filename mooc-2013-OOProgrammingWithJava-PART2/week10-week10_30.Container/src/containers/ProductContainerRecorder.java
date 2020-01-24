/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author leonardo
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory productContainerHistory;

    public ProductContainerRecorder(String productName, double tilavuus, double initialVolume) {
        super(productName, tilavuus);
        this.productContainerHistory = new ContainerHistory();
        super.addToTheContainer(initialVolume);      //add the initial volume to the container itself
        productContainerHistory.add(initialVolume);     //add the initial volume as the first situation on the container history
    }

    @Override
    public void addToTheContainer(double ammont) {
        super.addToTheContainer(ammont);        //call on the method to add to container from the container super class
        double volume = super.getVolume();
        productContainerHistory.add(volume);        //add the current volume as a situation in the container history
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double amountTaken = super.takeFromTheContainer(amount);        //take the amount from the container, and store however much was taken into a variable
        productContainerHistory.add(super.getVolume());     //record the situation into the container history
        return amountTaken;     //return the amount taken
//        if (amount < 0) {
//            return 0.0;
//        }
//        if (amount > super.getVolume()) {
//            super.takeFromTheContainer(super.getVolume());      //if the amount to be taken is greater than the volume, just take the available volume from the container
//            //Question: Do I set volume to zero now? as, in make a method to setVolume()?
//            return super.getVolume();
//        }
//        super.takeFromTheContainer(amount);
//        double volume = super.getVolume();
//        productContainerHistory.add(volume);
//        return amount;

    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + productContainerHistory.maxValue());
        System.out.println("Smallest product amount: " + productContainerHistory.minValue());
        System.out.println("Average: " + productContainerHistory.average());
        System.out.println("Greatest change: " + productContainerHistory.greatestFluctuation());
        System.out.println("Variance: " + productContainerHistory.variance());
    }

    public String history() {
        return productContainerHistory.toString();
    }

}
