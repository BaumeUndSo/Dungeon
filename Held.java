import java.awt.*;

public class Held 
{
    private int x,y;
    double angriff, ruestung, leben;    
    int gold;
    
    public Held()
    {
        leben = 255;
        angriff = 10;
        ruestung = 10;
        gold = 25;        
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
              
        g.setColor(new Color(0,(int) leben,0));
        g.fillOval(xPix+4,yPix+4,12,12);
    }    

}
