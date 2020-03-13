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
       if (typ==1)
      
          g.setColor(new Color(91,91,0)); else
          if (typ==4)
          g.setColor(new Color(238,59,59));else 
       if (typ==2)
          g.setColor(new Color(91,0,91)); else
       if (typ==3)
          g.setColor(new Color(0,91,91)); else
          g.setColor(Color.BLACK);
          
          
       g.fillRect(x,y,20,20);
       g.setColor(Color.BLACK);
       g.drawRect(x,y,20,20);
    }

}
