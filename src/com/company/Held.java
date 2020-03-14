package com.company;

import java.awt.*;

public class Held 
{
    private int x,y;
    int angriff, ruestung, leben,mana,fähigkeiten;
    int gold;
    int max_HP=400;
    
    public Held()
    {
        leben = 400;
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
              
        g.setColor(new Color(0,((int)leben/2),0));
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

}
