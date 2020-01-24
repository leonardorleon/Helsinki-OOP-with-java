package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;
    
    public UserInterface(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        //create layout
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);        //set the border layout to the container of the JFrame
        
        //create the components for the container
        JLabel calcValue = new JLabel(String.valueOf(calculator.giveValue()));      //set a label to have the calculator value
        JButton increaseButton = new JButton("click!");     //create a JButton with the "click!" name
        //create the action for the button
        ActionListener calcIncrease = new ClickListener(calculator, calcValue);     //create a new action where you pass along the calculator and the jlabel
        //add the action to the button 
        increaseButton.addActionListener(calcIncrease);     //now the button will have the calcIncrease function
        
        //let's add the components to the container
        container.add(calcValue, BorderLayout.WEST);        //add the calcValue label to the west of the container
        container.add(increaseButton, BorderLayout.SOUTH);      //add the increase button to the south of the container
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
