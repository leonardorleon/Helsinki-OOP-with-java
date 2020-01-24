/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author leonardo
 */
public class Substraction implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton zButton;

    public Substraction(JTextField input, JTextField output, JButton zButton) {
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

        //deal with the case when the value inputted is not an integer
        if (this.input.getText().matches("-?\\d+")) {
            substraction();
        } else {
            this.input.setText("");
        }

    }

    public void substraction() {
        int initial = Integer.parseInt(this.output.getText());
        int toSubstract = Integer.parseInt(this.input.getText());
        String result = String.valueOf(initial - toSubstract);

        this.output.setText(result);        //set the output to display the result of the operation
        this.input.setText("");

        if (this.output.getText().equals("0")) {
            zButton.setEnabled(false);
        } else {
            zButton.setEnabled(true);
        }
    }

}
