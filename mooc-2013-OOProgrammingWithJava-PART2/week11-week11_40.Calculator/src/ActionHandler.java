
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardo
 */
public class ActionHandler implements ActionListener{
    
    private JButton plus;
    private JButton minus;
    private JButton clear;
    private JTextField input;
    private JTextField output;
    private PerformAction perform;
    
    public ActionHandler(JButton plus, JButton minus, JButton clear, JTextField input, JTextField output){
        this.plus = plus;
        this.minus = minus;
        this.clear = clear;
        this.input = input;
        this.output = output;
        this.perform = new PerformAction();        //start the object which runs the actions
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        int inputValue = 0;     //the input is initially thought of as a zero until the input is correctly changed
        
        try {
            inputValue = Integer.parseInt(this.input.getText());        //if the value given is an integer, replace the inputValue variable to reflect what was given, otherwise nothing happens and the values stays at zero which won't affect the output in any way
        } catch (Exception ex) {
        }
        
        if (e.getSource() == plus){
            perform.add(inputValue);
        } else if (e.getSource() == minus){
            perform.substract(inputValue);
        } else if (e.getSource() == clear){
            perform.clear();
        }
        
        int result = perform.getResult();       //get the result from the operation
        
        input.setText("");      //input is cleared after any operation is completed
        output.setText("" + result);        //Set the ouput to be the result we got back
        
        //make sure clear button is not accessible when result is zero, but it is other than that
        if (result == 0){
            clear.setEnabled(false);
        } else {
            clear.setEnabled(true);
        }        
    }
    
}
