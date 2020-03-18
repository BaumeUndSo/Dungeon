package com.company;

import java.awt.*;

public class Held 
{
    private int x,y;
    int angriff, ruestung, leben,mana,fähigkeiten;
    int gold;
    int max_HP=200,max_mana=150;
    
    public Held()
    {
        leben = 200;
        angriff = 10;
        ruestung = 10;
        gold = 25;
        mana=100;
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
              
        g.setColor(new Color(0,((int)leben),0));
        g.fillOval(xPix+4,yPix+4,12,12);
    }
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

}
