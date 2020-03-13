package com.company;
import java.awt.*;

public class Dungeon
{
    private Feld[][] feld;
    private DungeonDaten daten;
    private Held kurt;
    private Item item;
    private int aktX, aktY,itemtyp,anzahl,schlüssel;
    private String test;
    private Inventar inv;
    boolean inventar;
    private Gegner antikurt;




    public Dungeon()
    {
        daten = new DungeonDaten();
        feld = new Feld[daten.breite][daten.hoehe];
        kurt = new Held();
        item=new Item();
        antikurt= new Gegner(aktX,aktY);





        for (int y=0; y<daten.hoehe; y++)
            for (int x=0; x<daten.breite; x++)
            {
                feld[x][y] = new Feld(x,y,daten.daten[y].charAt(x));
                //Sprung auf Startfeld
                if (daten.daten[y].charAt(x) == 'S')
                {
                    aktX = x;
                    aktY = y;
                    kurt.geheZu(aktX,aktY);
                }
            }

    }
    public void move(String richtung)
    {
        int neuY=aktY;
        int neuX=aktX;
        if(richtung=="rechts"){
            neuX=neuX+1;
        }else if(richtung=="links"){
            neuX=neuX-1;
        }else if(richtung=="unten"){
            neuY=neuY+1;
        }else if(richtung=="oben"){
            neuY=neuY-1;
        }

        //wenn Feld nicht gleich 1(leerfeld) aktion ausführen
        if (feld[neuX][neuY].getTyp() != 1){
            if (feld[neuX][neuY].getTyp() == 4){
                item.items[1]=item.items[1]+1;
            }
            if (feld[neuX][neuY].getTyp() == 2){
                if (item.items[1]>0){
                    item.items[1]=item.items[1]-1;
                }
            }
            //wenn Wand kein movement
            if (feld[neuX][neuY].getTyp() == 0){
                return;
            }
        }
        kurt.geheZu(neuX,neuY);
        aktY=neuY;
        aktX=neuX;
        //wenn Aktion ausgeführt Feld zurücksetzen
        feld[aktX][aktY].typ=1;
    }

    public void paint(Graphics g)
    {   antikurt.paint(g);
        if(inventar==true ){
        schlüssel=item.items[1];
        inv= new Inventar(schlüssel);
        inv.paint(g);
        inventar= false ;
    }
    else
        for (int y=0; y<daten.hoehe; y++)
            for (int x=0; x<daten.breite; x++)
                feld[x][y].paint(g);
        kurt.paint(g);


    }
}
