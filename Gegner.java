import java.awt.*;


public class Gegner {
    
    boolean tot;
     private int x,y,px,py;
    double angriff, ruestung, leben;    
    int gold;
    
    public Gegner(int xPos, int yPos){
               
        
         leben = 255;
        angriff = 10;
        ruestung = 10;
        gold = 25; 
        px=xPos;
        py=yPos;
        x=5;
        y=5;
        bewegen();
    }
    private void bewegen(){
         while (tot==false ){
            if (x>px){x--;
                 if (y>py){
                 y--;
                
                 }
                 else if (y<py){
                 y++;
                
                }
            
            }
            else if (x<px){x++;
                 if (y>py){
                 y--;
                
                 }
                 else if (y<py){
                 y++;
                
                }
            
            
        }
        
      }
      
    }

    public void run()     { 
        
        
    }
  

    public void paint(Graphics g){

         int xPix = 20 + x*20;
        int yPix = 20 + y*20;
              
        g.setColor(new Color(255,0,0));
        g.fillOval(xPix+4,yPix+4,12,12);
    }
    
}
