package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        //initiate the JFrame
        frame = new JFrame();
        
        //set the size of the JFrame
        frame.setPreferredSize(new Dimension(400, 200));
        
        //set closing operations
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      //set the program to close when using the cross button
        
        //create components
        createComponents(frame.getContentPane());       //pass along as parameter the container of JFrame
        
        //pack the components
        frame.pack();
        //make it visible
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        //make a boxlayout
        GridLayout layout = new GridLayout(3, 1);       //make it a grid of 3 lines and 1 row
        
        //set layout to the JFrame
        frame.setLayout(layout);
        
        //make all components
        JTextField textInputArea = new JTextField();      //empty text area
        JButton copyButton = new JButton("Copy!");      //copy button
        JLabel textCopiedArea = new JLabel();           //area where copied text is displayed
        
        //add actions to the components
        ActionEventListener NoticeAction = new ActionEventListener(textInputArea, textCopiedArea);
        copyButton.addActionListener(NoticeAction);     //add the action to the copy button
        
        //time to add all the components to the JFrame
        container.add(textInputArea);       //text input area at the top
        container.add(copyButton);      //copy button in the middle
        container.add(textCopiedArea);      //JLabel with the copied text in it.
    }
}
