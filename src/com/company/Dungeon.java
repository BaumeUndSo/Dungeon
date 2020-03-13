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
    public void goWest(String richtung)
    {
        int richtungstyp;
        if(richtung=="rechts"){
            richtungstyp=1;
        }else if(richtung=="links"){
            richtungstyp=2;
        }else if(richtung=="unten"){
            richtungstyp=3;
        }else if(richtung=="oben"){
            richtungstyp=4;
        }

        //wenn Feld nicht gleich 1(leerfeld) aktion ausführen
        if (feld[aktX-1][aktY].getTyp() != 1){
            if (feld[aktX-1][aktY].getTyp() == 4){
                item.items[1]=item.items[1]+1;
                aktX--;
                kurt.geheZu(aktX,aktY);
                feld[aktX][aktY].typ=1;
                return;
            }
            if (feld[aktX-1][aktY].getTyp() == 2){
                if (item.items[1]>0){
                    aktX--;
                    kurt.geheZu(aktX,aktY);
                    item.items[1]=item.items[1]-1;
                    feld[aktX][aktY].typ=1;
                    return;
                }
            }
            return;
        }
        aktX--;
        kurt.geheZu(aktX,aktY);

    }
/*
    public void goWest()
    {
        if (aktX < 1) return;

        //wenn Feld nicht gleich 1 aktion ausführen
        if (feld[aktX-1][aktY].getTyp() != 1){
            if (feld[aktX-1][aktY].getTyp() == 4){
                item.items[1]=item.items[1]+1;
                aktX--;
                kurt.geheZu(aktX,aktY);
                feld[aktX][aktY].typ=1;
                return;
            }
            if (feld[aktX-1][aktY].getTyp() == 2){
                if (item.items[1]>0){
                    aktX--;
                    kurt.geheZu(aktX,aktY);
                    item.items[1]=item.items[1]-1;
                    feld[aktX][aktY].typ=1;
                    return;
                }
            }
            return;
        }
        aktX--;
        kurt.geheZu(aktX,aktY);

    }

    public void goEast()
    {
        if (aktX > daten.breite-2) return;
        if (feld[aktX+1][aktY].getTyp() != 1) {
            if (feld[aktX+1][aktY].getTyp() == 4){

                item.items[1]=item.items[1]+1;
                aktX++;
                kurt.geheZu(aktX,aktY);
                feld[aktX][aktY].typ=1;
                return;
            }
            if (feld[aktX+1][aktY].getTyp() == 2){
                if (item.items[1]>=1){

                    aktX++;
                    kurt.geheZu(aktX,aktY);
                    feld[aktX][aktY].typ=1;
                    item.items[1]=item.items[1]-1;

                }
            }
            return;
        }

        aktX++;
        kurt.geheZu(aktX,aktY);

    }

    public void goSouth()
    {
        if (aktY <1) return;
        if (feld[aktX][aktY-1].getTyp() != 1) {
            if (feld[aktX][aktY-1].getTyp() == 4){
                item.items[1]=item.items[1]+1;
                aktY--;
                kurt.geheZu(aktX,aktY);
                feld[aktX][aktY].typ=1;
                return;
            }
            if (feld[aktX][aktY-1].getTyp() == 2){
                if (item.items[1]>0){
                    aktY--;
                    kurt.geheZu(aktX,aktY);
                    feld[aktX][aktY].typ=1;
                    item.items[1]=item.items[1]-1;
                    return;
                }
            }
            return;
        }
        aktY--;
        kurt.geheZu(aktX,aktY);

    }

    public void goNorth()
    {
        if (aktY > 16) return;
        if (feld[aktX][aktY+1].getTyp() != 1){
            if (feld[aktX][aktY+1].getTyp() == 4){
                item.items[1]=item.items[1]+1;
                aktY++;
                kurt.geheZu(aktX,aktY);
                feld[aktX][aktY].typ=1;
                return;
            }
            if (feld[aktX][aktY+1].getTyp() == 2){
                if (item.items[1]>0){

                    aktY++;
                    kurt.geheZu(aktX,aktY);
                    feld[aktX][aktY].typ=1;
                    item.items[1]=item.items[1]-1;
                    return;
                }
            }
            return;
        }
        aktY++;
        kurt.geheZu(aktX,aktY);
    }
    */

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
