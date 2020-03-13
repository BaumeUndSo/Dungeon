package com.company;

import javax.swing.*;
import java.awt.*;

public class Kampf extends JFrame   {
     private int  leben,stärke,mana,faehigkeiten,rüstung,gegnerrüstung,gegnerleben,gegnerstärke ,gegnerwert;




    public Kampf(int pleben, int pstärke, int pmana ,int pfähigkeiten,int prüstung ,int gleben, int grüstung ,int gstärke, int pwert){
        //Heldenstats
        leben=pleben;
        stärke=pstärke;
        mana=pmana;
        faehigkeiten=pfähigkeiten;
        // Gegnerstats
        gegnerleben=gleben;
        gegnerrüstung=grüstung;
        gegnerstärke= gstärke;
        gegnerwert=pwert;


        setDefaultCloseOperation( EXIT_ON_CLOSE);
        setLocation( 100, 100);
        setSize( 512,384 );
        ImageIcon icon = new ImageIcon ("C:\\Users\\julia\\Documents\\GitHub\\Dungeon\\Dungeon\\src\\com\\company\\Held.jpg");
        JLabel l1 = new JLabel (icon);
       setResizable(true);
        add(l1);


    }
    public static void main(String[] args)
    {
        new Kampf(100,200,200,3,20,100,50,20,20).setVisible(true);
    }
}
