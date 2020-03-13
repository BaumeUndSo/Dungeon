package com.company;

import javax.swing.*;
import java.awt.*;

public class Kampf  extends JFrame {
    JLabel Held, Mob, Held2, lebenhalb, lebenviertel, lebendreiviertel, test1[],Mob2[];
    Lebensanzeige Held1, Mob1;
    int[] test;
    int typ;


    private int leben, stärke, mana, faehigkeiten, rüstung, gegnerrüstung, gegnerleben, gegnerstärke, gegnerwert;


    public Kampf(int pleben, int pstärke, int pmana, int pfähigkeiten, int prüstung, int gleben, int grüstung, int gstärke, int pwert) {

        setBackground(Color.WHITE);
        setTitle("Kampf");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        setLocationRelativeTo(null);


        //Heldenstats
        leben = pleben;
        stärke = pstärke;
        mana = pmana;
        faehigkeiten = pfähigkeiten;
        // Gegnerstats
        gegnerleben = gleben;
        gegnerrüstung = grüstung;
        gegnerstärke = gstärke;
        gegnerwert = pwert;

        Held = new JLabel();

        ImageIcon icon = new ImageIcon("C:\\Users\\julia\\Documents\\GitHub\\Dungeon\\Dungeon\\src\\com\\company\\Held.png");
        getContentPane().setLayout(null);
        Held.setIcon(icon);
        getContentPane().add(Held);
        Held.setBounds(100, 200, 500, 300);
        add(Held);
        setVisible(true);

        Mob = new JLabel();

        ImageIcon icon1 = new ImageIcon("C:\\Users\\julia\\Documents\\GitHub\\Dungeon\\Dungeon\\src\\com\\company\\Gegner.png");
        Mob.setIcon(icon1);
        getContentPane().add(Mob);
        Mob.setBounds(500, 100, 400, 200);
        add(Mob);
        Mob2= new JLabel[20];
        test1= new JLabel[20];
        setVisible(true);
        Anzeige(leben);
        LebenGegner(gegnerleben);


    }



    public void Anzeige(int pleben) {
        int g, m, l, px;
        l = pleben;
        m = 0;
        g = 0;
        px = 0;
        for (int i = 0; i <= l; i++) {
            m++;
            if (m == 20) {
                g++;
                m = 0;

            }

        }
        Held1 = new Lebensanzeige();



        for (int i = 0; i <= g; i++) {

            test1[g] = new JLabel();
            test1[g].setIcon(Held1.vollesherz);
            getContentPane().add(test1[g]);
            add(test1[g]);
            test1[g].setBounds(10 + px, 30, 49, 51);
            setVisible(true);
            px = i * 50;

        }
          if (m<=5){

              test1[g] = new JLabel();
              test1[g].setIcon(Held1.viertelherz);
              getContentPane().add(test1[g]);
              add(test1[g]);
              test1[g].setBounds(10 + px, 30, 49, 51);
              setVisible(true);


            }
            else if (m<=10){


              test1[g] = new JLabel();
              test1[g].setIcon(Held1.halbesherz);
              getContentPane().add(test1[g]);
              add(test1[g]);
              test1[g].setBounds(10 + px, 30, 49, 51);
              setVisible(true);


          }
            else if (m<=15){


              test1[g] = new JLabel();
              test1[g].setIcon(Held1.dreiviertelherz);
              getContentPane().add(test1[g]);
              add(test1[g]);
              test1[g].setBounds(10 + px, 30, 49, 51);
              setVisible(true);







            }





        }

    public void LebenGegner(int pleben) {
        int g, m, l, px;
        l = pleben;
        m = 0;
        g = 0;
        px = 0;
        for (int i = 0; i <= l; i++) {
            m++;
            if (m == 20) {
                g++;
                m = 0;

            }

        }
        Mob1 = new Lebensanzeige();



        for (int i = 0; i <= g; i++) {

            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.vollesherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(450 + px, 400, 49, 51);
            setVisible(true);
            px = i * 50;

        }
        if (m<=5){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.viertelherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(450 + px, 400, 49, 51);
            setVisible(true);
            px =g*50;

        }
        else if (m<=10){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.halbesherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(450+ px, 400, 49, 51);
            setVisible(true);
            px =g*50;

        }
        else if (m<=15){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.dreiviertelherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(450 + px, 400, 49, 51);
            setVisible(true);
            px =g*50;






        }





    }







        public static void main (String[]args)
        {
            new Kampf(70, 200, 200, 3, 20, 100, 50, 20, 20);


        }

    }

