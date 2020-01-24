package drawing.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        int eyeDimension = 50;
        
        graphics.fillRect(75, 45, eyeDimension, eyeDimension);
        graphics.fillRect(250, 45, eyeDimension, eyeDimension);
        graphics.fillRect(25, 200, eyeDimension, eyeDimension);
        graphics.fillRect(300, 200, eyeDimension, eyeDimension);
        graphics.fillRect(75, 250, 225, eyeDimension);
    }
}
