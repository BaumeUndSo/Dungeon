package com.company;

import java.awt.*;

public class Held 
{
    private int x,y;
    int angriff, ruestung, leben,mana,fähigkeiten,erfahrung,nextLVL,LVL;
    int gold;
    int max_HP,max_mana;
    
    public Held()
    {
        LVL=1;
        erfahrung = 0;
        nextLVL=100;
        max_HP=100;
        max_mana=100;
        leben = 100;
        angriff = 10;
        ruestung = 10;
        gold = 25;
        mana=50;
        fähigkeiten=0;

    }
    
    public void geheZu(int xPos, int yPos)
    {
       
       x = xPos;
       y = yPos;
       
    }    
    
    public void paint(Graphics g)
    {
        int xPix = 20 + x*20;
        int yPix = 20 + y*20;
        if(leben>=0) {
            g.setColor(new Color(0, 255, 0));
        }else{
            g.setColor(new Color(255, 12, 0));
        }
        g.fillOval(xPix+4,yPix+4,12,12);
    }

    //HP
    public void addHP(int addHP)
    {
        if((leben+addHP)>max_HP){
            leben=max_HP;
        }else{
            leben=leben+addHP;
        }
    }
    public int getHP()
    {
        return leben;
    }
    public int getmaxHP()
    {
        return max_HP;
    }

    //XP
    public void addXP(int input_erfahrung)
    {
        if((erfahrung+input_erfahrung)>=nextLVL){
            //Level Up !
            LVL=LVL+1;
            erfahrung=(erfahrung+input_erfahrung)-nextLVL;

            max_HP=max_HP+20;
            leben=leben+20;
            max_mana=max_mana+10;
            mana=mana+10;

            if(LVL<=3) {
                nextLVL = nextLVL * 2;
            }else if(LVL<=6){
                nextLVL = nextLVL*3/2;
            }
        }else{
            //Kein Level UP!
            erfahrung=erfahrung+input_erfahrung;
        }

    }
    public int getLVL()
    {
        return LVL;
    }
    public int getXP()
    {
        return erfahrung;
    }
    public int getNextLVL()
    {
        return nextLVL;
    }


    //Mana
    public void addmana(int addmana)
    {
        if((mana+addmana)>max_HP){
            mana=max_mana;
        }else{
            mana=mana+addmana;
        }
    }
    public int getmana()
    {
        return mana;
    }
    public int getmaxmana()
    {
        return max_mana;
    }
    public int getAngriff()
    {
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
        return angriff;
    }

}
