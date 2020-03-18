package com.company;

import java.awt.*;

public class Feld
{
    public int typ;
    private int x,y;
    
    public Feld(int x, int y, char t)
    {
        this.x = 20+x*20;
        this.y = 20+y*20;
        if (t == 'M') typ = 8; else
        if (t == 'H') typ = 7; else
        if (t == 'G') typ = 5; else
        if (t == 'E')  typ= 6; else
        if (t == 'W') typ = 0; else
        if (t == 'I')  typ= 4; else 
        if (t == 'V') typ = 2; else
        if (t == 'S') typ = 3; else typ = 1;
    }
    
    public int getTyp()
    {
       return typ;
    }
    
    public void paint(Graphics g)
    {
       if (typ==1) g.setColor(new Color(91,91,0)); else
       if (typ==4) g.setColor(new Color(238,59,59));else
       if (typ==2) g.setColor(new Color(91,0,91)); else
       if (typ==3) g.setColor(new Color(91,91,0)); else
       if (typ==5) g.setColor(new Color(91,0, 11)); else
       if(typ==6) g.setColor(new Color(71, 35, 4)); else
       if(typ==7) g.setColor(new Color(7, 91, 0)); else
       if (typ==8) g.setColor(new Color(5, 62, 91)); else
       g.setColor(Color.BLACK);


          
       g.fillRect(x,y,20,20);
       g.setColor(Color.BLACK);
       g.drawRect(x,y,20,20);
    }

}
