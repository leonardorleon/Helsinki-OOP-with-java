
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */

public class ZeroOut implements ActionListener {

    private JTextField input;
    private JTextField output;
    private JButton zButton;
    

    public ZeroOut(JTextField input, JTextField output, JButton zButton) {
        this.input = input;
        this.output = output;
        this.zButton = zButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.output.getText().isEmpty()) {
            this.output.setText("0");       //if coming in the output field is empty, set it to a zero
        } else if (this.input.getText().isEmpty()) {
            this.input.setText("0");        //if coming in the input field is empty, set it to a zero
        }
        
        this.output.setText("0");       //set the output text to 0
        this.input.setText("");
        
        zButton.setEnabled(false);      //since the zButton clears the output, it should be set to disabled after its use
    }

}
