package greeter.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Swing on");     //create a new Jframe object (window), it must be created and declared visible in the run() method
        frame.setPreferredSize(new Dimension(400, 200));        //set the size for the Jframe object

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      //tells the Jframe object that the user interface has to close when the user presses the cross icon

        createComponents(frame.getContentPane());       //the method create components is given the Jframe container object as a parameter. Where we can add user interface components

        frame.pack();       //packs the JFrame object as defined before and sorts the uder interface components of the container object contained by JFrame
        frame.setVisible(true);     //set visibility to true to show the uder interface to the user
    }

    private void createComponents(Container container) {
        //JButton button = new JButton("Click!");
        //container.add(button);
        //JLabel text = new JLabel("Text.");
        //container.add(text);
        JLabel text = new JLabel("Hi!");     //create a Jlabel component with the text "Hi!"
        container.add(text);        //retrieve the container object from the JFrame object and add the JLabel using the add method.
    }

    public JFrame getFrame() {
        return frame;
    }
}
