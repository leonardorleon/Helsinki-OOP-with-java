package survey;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        //first we crate the JFrame
        frame = new JFrame("Survey");

        //now let's set the dimensions of the frame
        frame.setPreferredSize(new Dimension(200, 300));
        
        //set the default closing action
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //we can now create the components
        createComponents(frame.getContentPane());       //we give the Jframe container as parameter

        frame.pack();       //we pack the components added to the JFrame
        frame.setVisible(true);     //set the visibility to true so that it is displayed to the user
    }

    public JFrame getFrame() {
        return frame;
    }

    private void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);      //create a box layout with vertical orientation
        container.setLayout(layout);        //set the layout for the container

        container.add(new JLabel("Are you?"));      //first add a text component
        //now we add a checkbox component for yes and no
        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));

        //another text component is added
        container.add(new JLabel("Why?"));

        //let's now add JRadialButton components to the list
        JRadioButton noReason = new JRadioButton("No reason.");
        JRadioButton becauseFun = new JRadioButton("Because it is fun!");

        //the radial buttons must be in a group, so that only one can be chosen at a time
        ButtonGroup radialGroup = new ButtonGroup();
        radialGroup.add(noReason);
        radialGroup.add(becauseFun);

        //now add to container
        container.add(noReason);
        container.add(becauseFun);

        //lastly we need a JButton to say Done!
        JButton done = new JButton("Done!");

        container.add(done);
    }
}
