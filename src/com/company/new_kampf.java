package com.company;

import java.awt.*;
public class new_kampf {
    int schlüssel,leben,mana,maxleben,maxmana,healpots,erfahrung,nextLVL,LVL;
    public new_kampf(int pleben,int pmaxleben,int pmana,int pmaxmana,int perfahrung,int pnextLVL,int pLVL) {
        leben=pleben;
        mana=pmana;
        maxleben=pmaxleben;
        maxmana=pmaxmana;
        erfahrung=perfahrung;
        nextLVL=pnextLVL;
        LVL=pLVL;
    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(100,100,300,250);
        g.setColor(Color.BLACK);
        g.drawRect(100,100,300,250);

        g.drawString("Hallo",110,120);
    }

}