package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Anwendung extends JFrame implements KeyListener
{
    Dungeon brett;





    public Anwendung()
    {
        brett = new Dungeon();



        setSize(500,500);
        setTitle("ZORK 1-01");
        setResizable(false);
        setVisible(true);
        initComponents();
        addKeyListener(this);



    }
    public void run(){

    }
    public void initComponents()
    {

    }

    public void keyPressed(KeyEvent e)
    {
        int openkampf;
        if (brett.Kampf1==false) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                openkampf=brett.move("rechts");
                if(openkampf==1){
                    brett.openkampf = true;
                }
            }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                openkampf=brett.move("links");
                if(openkampf==1){
                    brett.openkampf = true;
                }
            }else if (e.getKeyCode() == KeyEvent.VK_UP) {
                openkampf=brett.move("oben");
                if(openkampf==1){
                    brett.openkampf = true;
                }
            }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                openkampf=brett.move("unten");
                if(openkampf==1){
                    brett.openkampf = true;
                }
            }else if (e.getKeyCode() == KeyEvent.VK_E) {
                brett.inventar = true;
            }
        }


        repaint();
    }

    public void paint(Graphics g)
    {


        brett.paint(g);
    }

    public static void main(String[] args)
    {
        new Anwendung();
    }



    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}
