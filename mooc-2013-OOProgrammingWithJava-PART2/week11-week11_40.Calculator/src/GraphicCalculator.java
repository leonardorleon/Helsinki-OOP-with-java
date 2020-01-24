
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */
public class GraphicCalculator implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());       //pass along the container to the createComponents method
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        //create layout
        GridLayout layout = new GridLayout(3, 1);
        frame.setLayout(layout);
        frame.setPreferredSize(new Dimension(300, 200));
        
        //create components
        JTextField resultField = new JTextField("0");       //results field starts with a value of zero
        resultField.setEnabled(false);
        JTextField inputField = new JTextField();       //input field starts empty
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton clear = new JButton("Z");
        clear.setEnabled(false);        //initially result field is empty, so not usable
        
        //the three buttons go in a panel
        JPanel buttonsMenu = new JPanel(new GridLayout(1, 3));
        buttonsMenu.add(plus);
        buttonsMenu.add(minus);
        buttonsMenu.add(clear);
        
        //now we need to add an action to each one of them
        ActionListener handler = new ActionHandler(plus, minus, clear, inputField, resultField);     //the action handler directs the action according to the button pressed
        plus.addActionListener(handler);
        minus.addActionListener(handler);
        clear.addActionListener(handler);
        
        //add the components to the frame
        container.add(resultField);
        container.add(inputField);
        container.add(buttonsMenu);
        
    }

    public JFrame getFrame() {
        return frame;
    }

}
