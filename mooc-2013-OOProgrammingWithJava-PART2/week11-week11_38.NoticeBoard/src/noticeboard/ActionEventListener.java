/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author leonardo
 */
public class ActionEventListener implements ActionListener{
    
    private JTextField inputText;
    private JLabel displayText;
    
    public ActionEventListener(JTextField origin, JLabel destination){
        this.inputText = origin;
        this.displayText = destination;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //set the JLabel to display the text provided in the JTextArea
        displayText.setText(inputText.getText());
        //now empty the JTextArea for a new input
        inputText.setText("");
    }
    
}
