/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author leonardo
 */
public class Box extends Figure{
    
    private final int width;
    private final int height;
    
    public Box(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    Box(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), width, height);
    }
    
}
