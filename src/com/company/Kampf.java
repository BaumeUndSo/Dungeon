package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Kampf  extends JFrame implements ActionListener {
    JLabel Held, Mob, Held2, lebenhalb, lebenviertel, lebendreiviertel, test1[],Mob2[],vs,manaanzeige;
    Lebensanzeige Held1, Mob1;
    JButton fähigkeit1,fähigkeit2,fähigkeit3,fähigkeit4;
    int[] test;
    int typ;
    boolean istda;


    private int leben, stärke, mana, faehigkeiten, rüstung, gegnerrüstung, gegnerleben, gegnerstärke, gegnerwert,f1schaden,f2schaden,f3schaden,f4schaden,f1mana,f2mana,f3mana,f4mana;


    public Kampf(int pleben, int pstärke, int pmana, int pfähigkeiten, int prüstung, int gleben, int grüstung, int gstärke, int pwert) {

            istda=false  ;
        f1schaden=pstärke;
        f2schaden=pstärke+10;
        f3schaden=pstärke+30;
        f4schaden=pstärke+50;

        f1mana=20;
        f2mana=50;
        f3mana=70;
        f4mana=120;





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





        // der Held wird als bild erstellt
        Held = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\julia\\Documents\\GitHub\\Dungeon\\Dungeon\\src\\com\\company\\Held.png");
        getContentPane().setLayout(null);
        Held.setIcon(icon);
        getContentPane().add(Held);
        Held.setBounds(50, 120, 500, 300);
        add(Held);
        setVisible(true);

        // der mob wird als Bild hinzugefügt

        Mob = new JLabel();
        ImageIcon icon1 = new ImageIcon("C:\\Users\\julia\\Documents\\GitHub\\Dungeon\\Dungeon\\src\\com\\company\\Gegner.png");
        Mob.setIcon(icon1);
        getContentPane().add(Mob);

        Mob.setBounds(650, 140, 400, 200);
        add(Mob);

        //asdjans
        vs= new JLabel("VS");
        vs.setFont(new Font("Arial",Font.BOLD,40));
        getContentPane().add(vs);
        vs.setBounds(450,140,200,200);

        add(vs);


    fähigkeit1= new JButton();
    fähigkeit1.setText("<html><body><p>Donnerblitz</p><p>Mana:20</p><p>Schaden:"+f1schaden+"</p></body></html>");
    fähigkeit1.setBounds(50,400,200,100);
   fähigkeit1.addActionListener(this);
    add(fähigkeit1);
    setVisible(true);

        if (pfähigkeiten>=2) {
            fähigkeit2 = new JButton();
            fähigkeit2.setText("<html><body><p>Ruckzuckhieb</p><p>Mana:50</p><p>Schaden:" + f2schaden + "</p></body></html>");
            fähigkeit2.setBounds(280, 400, 200, 100);
            fähigkeit2.addActionListener(this);
            add(fähigkeit2);
            setVisible(true);

        }
         if (pfähigkeiten>=3)
        {fähigkeit3= new JButton();
    fähigkeit3.setText("<html><body><p>Volttackle</p><p>Mana:70</p><p>Schaden:" +f3schaden+"</p></body></html>");
    fähigkeit3.setBounds(500,400,200,100);
    fähigkeit3.addActionListener(this);
    add(fähigkeit3);}


         if (pfähigkeiten>=4){
    fähigkeit4=new JButton();
    fähigkeit4.setText("<html><body><p>Volttackle</p><p>Mana:120</p><p>Schaden:"+f4schaden+"</p></body></html>");
    fähigkeit4.setBounds(720,400,200,100);
    fähigkeit4.addActionListener(this);
    add(fähigkeit4);}






        // Array für jedes einzelne Herz max 20 für den Helden
        Mob2= new JLabel[20];
        test1= new JLabel[20];
        setVisible(true);
        aktualiesierung();





    }



        public void Anzeige(int pleben) {
        int g, m, l, px;
        l = pleben;
        m = 0;
        g = 0;
        px = 0;





            manaanzeige= new JLabel("Mana:"+mana+"/"+200);
            manaanzeige.setFont(new Font("Arial",Font.BOLD,15));
            getContentPane().add(manaanzeige);
            manaanzeige.setBounds(10,70,100,70);
            add(manaanzeige);
            setVisible(true);
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






        } // Anzeige der Leben für den Helden

        public void LebenGegner(int pleben) // Lebensanzeige für Gegner
          {
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
            Mob2[g].setBounds(550 + px, 30, 49, 51);
            setVisible(true);
            px = i * 50;

        }
        if (m<=5){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.viertelherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(550 + px, 30, 49, 51);
            setVisible(true);
            px =g*50;

        }
        else if (m<=10){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.halbesherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(550 + px, 30, 49, 51);
            setVisible(true);
            px =g*50;

        }
        else if (m<=15){
            g++;
            Mob2[g] = new JLabel();
            Mob2[g].setIcon(Mob1.dreiviertelherz);
            getContentPane().add(Mob2[g]);
            add(Mob2[g]);
            Mob2[g].setBounds(550 + px, 30, 49, 51);
            setVisible(true);
            px =g*50;






        }





    }




   public void aktualiesierung(){
        if(istda== true) {



            System.out.println("1");
            for (int i = 0; i < test1.length; i++) {


               test1[i].setVisible(false);
            }
           // for (int i = 0; i < Mob2.length; i++) {
             //   Mob2[i].remove(i);


            //}
         // manaanzeige.remove(1);


        }



    //   Anzeige(leben);
      // LebenGegner(gegnerleben);
     

   }
   public void actionPerformed(ActionEvent e){
        if(e.getSource()==fähigkeit1){
            gegnerleben=gegnerleben-f1schaden;
            mana=mana-f1mana;
           aktualiesierung();

        }



   }








        public static void main (String[]args)
        {
            new Kampf(70, 30, 200, 2, 20, 100, 50, 20, 20);


        }


}

