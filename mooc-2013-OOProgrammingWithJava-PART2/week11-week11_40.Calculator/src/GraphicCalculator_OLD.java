
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator_OLD implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");       //initiate the frame of the application
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());       //pass the JFrame container as parameter to create the components
        
        frame.pack();       //pack the components on the frame
        frame.setVisible(true);     //set the frame to be visible
    }

    private void createComponents(Container container) {
        //create the layout
        GridLayout baseLayout = new GridLayout(3, 1);       //create the base layout for the frame
        frame.setLayout(baseLayout);        //set the layout on the frame
        frame.setPreferredSize(new Dimension(400, 200));        //set a visible initial dimension
        
        //create components
        JTextField topTextField = new JTextField("0"); 
        topTextField.setEnabled(false);     //the top field should not be usable, it'll only display text
        
        JTextField bottomTextField = new JTextField("");      //second text field, where inputs are given
        
        JPanel operationPanel = new JPanel(new GridLayout(1, 3));       //the bottom section of the frame, will have a panel with three buttons
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton zButton = new JButton("Z");
        operationPanel.add(plusButton);
        operationPanel.add(minusButton);
        operationPanel.add(zButton);
        
        //Addition functionality for "+" button
        ActionListener addAction = new Addition(bottomTextField, topTextField, zButton);     //new action object for the + button
        plusButton.addActionListener(addAction);        //set the addition action listener for the "+" button
        
        //substractioin functionality for "-" button
        ActionListener substractAction = new Substraction(bottomTextField, topTextField, zButton);       //new action object for the - button
        minusButton.addActionListener(substractAction);
        

        //zero out action for "Z" button
        zButton.setEnabled(false);
        ActionListener zeroAction = new ZeroOut(bottomTextField, topTextField, zButton);
        zButton.addActionListener(zeroAction);
            
        //add components to the JFrame container
        container.add(topTextField);
        container.add(bottomTextField);
        container.add(operationPanel);
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
