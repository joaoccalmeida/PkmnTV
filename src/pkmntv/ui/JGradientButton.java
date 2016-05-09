/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmntv.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author João
 */
public class JGradientButton extends JButton {
    
        private Color color;
    
        public JGradientButton() {
            super();
            setContentAreaFilled(false);
            setFocusPainted(false); // used for demonstration
        }

        public void setColor(Color color){
            this.color = color;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0), getColor(), 
                    new Point(0, getHeight()), 
                    getColor().darker()));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    }
