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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            brett.move("rechts");
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            brett.move("links");
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            brett.move("oben");
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            brett.move("unten");
        else if (e.getKeyCode() == KeyEvent.VK_E)
            brett.inventar=true ;


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
