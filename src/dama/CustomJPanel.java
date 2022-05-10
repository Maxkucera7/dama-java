/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dama;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CustomJPanel extends JPanel{
        int figurka=0;
        int pozicex=0;
        int pozicey=0;
        public BufferedImage image;
        JLabel picLabel = new JLabel();
        
        public CustomJPanel(int velikost, int locationy,int locationx){
        this.setSize(velikost,velikost);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setLocation(locationx, locationy);    
        this.add(picLabel);
    }
        
    public int getFigurka() {
        return figurka;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public JLabel getPicLabel() {
        return picLabel;
    }

    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }

    public int getPozicex() {
        return pozicex;
    }

    public int getPozicey() {
        return pozicey;
    }

    public void setFigurka(int figurka) {
        this.figurka = figurka;
    }

    public void setPozicex(int pozicex) {
        this.pozicex = pozicex;
    }

    public void setPozicey(int pozicey) {
        this.pozicey = pozicey;
    }

}
