/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author leonardo
 */
public class DrawingBoard extends JPanel {
    
    private final Figure figure;
    
    public DrawingBoard(Figure figure){
        super.setBackground(Color.WHITE);
        this.figure = figure;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        figure.draw(g);
    }
}
