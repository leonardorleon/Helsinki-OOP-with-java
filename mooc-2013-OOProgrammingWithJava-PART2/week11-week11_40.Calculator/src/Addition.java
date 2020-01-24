
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
public class Addition implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton zButton;

    public Addition(JTextField input, JTextField output, JButton zButton) {
        this.input = input;
        this.output = output;
        this.zButton = zButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //deal with the case when the output or input fields are empty
        if (this.output.getText().isEmpty()) {
            this.output.setText("0");       //if coming in the output field is empty, set it to a zero
        } else if (this.input.getText().isEmpty()) {
            this.input.setText("0");        //if coming in the input field is empty, set it to a zero
        }

        // --This is what I ended up using.
        //deal with the case when the value inputted is not an integer
        if (this.input.getText().matches("-?\\d+")){
            addition();
        }else{
            this.input.setText("");
        }
        
//// --This is what I tried when I was using the try-catch block
//        try {
//            Integer.parseInt(this.input.getText());
//        } catch (NumberFormatException ex) {
//            this.input.setText("");
//        }
        
        addition();
        
    }

    public void addition() {
        int initial = Integer.parseInt(this.output.getText());      //value at the beginning of the operation
        int toAdd = Integer.parseInt(this.input.getText());     //value that the user inputted to be added
        int result = initial + toAdd;       //result of the operation, which will be stored at the output text field

        //System.out.println(value);
        this.output.setText(String.valueOf(result));       //set the output to the result of the addition
        //this.output.getText();
        this.input.setText("");

        //make sure zbutton is usable if the output field is not zero
        if (this.output.getText().equals("0")) {
            zButton.setEnabled(false);
        } else {
            zButton.setEnabled(true);
        }
    }


}
