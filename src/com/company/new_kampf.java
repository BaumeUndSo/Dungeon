package com.company;

import java.awt.*;
public class new_kampf {
    int x,schlüssel,leben,mana,maxleben,maxmana,angriff,healpots,erfahrung,nextLVL,LVL,gegnertyp,gegnermaxHP,gegnerHP,gegnerAngriff,posx,posy;
    String pfeil;
    public new_kampf(int pleben,int pmaxleben,int pmana,int pmaxmana,int perfahrung,int pnextLVL,int pLVL,int pgegnertyp) {
        leben=pleben;
        mana=pmana;
        maxleben=pmaxleben;
        maxmana=pmaxmana;
        erfahrung=perfahrung;
        nextLVL=pnextLVL;
        LVL=pLVL;
        gegnertyp=pgegnertyp;
        angriff=10;
        if(gegnertyp==1){
            gegnermaxHP=50;
            gegnerHP=50;
            gegnerAngriff=5;
        }
    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(100,40,300,460);

        g.setColor(Color.BLACK);
        g.drawRect(100,40,300,460);

        //Überschriften
        g.drawString("Held",110,60);
        g.drawString("Kampf!",225,60);
        g.drawString("Gegner",350,60);
        //Start - HP
        posy=80;
        g.drawString("HP: "+leben+"/"+maxleben,110,posy);
        g.drawString("HP: "+gegnerHP+"/"+gegnermaxHP,325,posy);
        x=1;
        while(leben>0 && gegnerHP>0) {
            //Held Angriff berechnen
            double tmpwurzelwert;
            tmpwurzelwert = Math.sqrt(mana)*2;
            if(mana>=5) {
                mana = mana - 5;
            }else{
                mana=0;
            }
            angriff= (int)Math.round(tmpwurzelwert);
            if(angriff<5){
                angriff=5;
            }

            if(x==1) {
                pfeil = "";
                posx = 200;
                for (int i = 0; i <= 30; i++) {
                    posx = posx + 3;
                    sleep(10);
                    if (i == 30) {
                        g.drawString(">", posx, posy);
                    } else {
                        g.drawString("-", posx, posy);
                    }
                }
                g.drawString("" + angriff, 235, (posy - 5));
                sleep(50);
                gegnerHP = gegnerHP - angriff;
                x=0;
            }else{
                posx=300;
                for (int i = 0; i <= 30; i++) {
                    posx = posx - 3;
                    sleep(10);
                    if (i == 30) {
                        g.drawString("<", posx, posy);
                    } else {
                        g.drawString("-", posx, posy);
                    }
                }
                g.drawString("" + gegnerAngriff, 245, (posy - 5));
                sleep(50);
                leben = leben - gegnerAngriff;
                x=1;
            }
            posy = posy + 20;
            g.drawString("HP: " + leben + "/" + maxleben, 110, posy);
            g.drawString("HP: " + gegnerHP + "/" + gegnermaxHP, 325, posy);
            if (gegnerHP <= 0) {
                g.drawString("Sieg! 100 Erfahrung erhalten!", 185, (posy+20));
            }else if(leben <= 0){
                g.drawString("Niederlage...", 225, posy);
            }
        }
    }
    public void sleep(int millies){
        try {
            Thread.sleep(millies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}