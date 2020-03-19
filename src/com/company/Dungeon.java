package com.company;
import java.awt.*;

public class Dungeon
{
    private Feld[][] feld;
    private DungeonDaten daten;
    private Held kurt;
    private Item item;
    private int aktX, aktY,itemtyp,anzahl,schlüssel,gegnertyp;
    private String test;
    private Inventar inv;
    private new_kampf new_kampf;
    boolean inventar,openkampf;
    public Gegner Schwach,Stark;
    public boolean Kampf1;
    private  Kampf kampf;





    public Dungeon()
    {
        daten = new DungeonDaten();
        feld = new Feld[daten.breite][daten.hoehe];
        kurt = new Held();
        item=new Item();






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
    public int move(String richtung)
    {
        if(kurt.getHP()>0) {
            int neuY = aktY;
            int neuX = aktX;
            if (richtung == "rechts") {
                neuX = neuX + 1;
            } else if (richtung == "links") {
                neuX = neuX - 1;
            } else if (richtung == "unten") {
                neuY = neuY + 1;
            } else if (richtung == "oben") {
                neuY = neuY - 1;
            }

            //wenn Feld nicht gleich 1(leerfeld) aktion ausführen
            if (feld[neuX][neuY].getTyp() != 1) {
                if (feld[neuX][neuY].getTyp() == 4) {
                    item.items[1] = item.items[1] + 1;
                }
                if (feld[neuX][neuY].getTyp() == 5) {
                    /*
                    // neuer kampf wir gestartet
                    kampf = new Kampf(kurt.leben, kurt.angriff, kurt.mana, kurt.fähigkeiten, 20, 100, 50, 20, 20);
                    Kampf1 = true;
                    */
                    openkampf=true;
                }
                if (feld[neuX][neuY].getTyp() == 6) {
                    /*
                    kampf = new Kampf(kurt.leben, kurt.angriff, kurt.mana, kurt.fähigkeiten, 20, 100, 50, 20, 20);
                    Kampf1 = true;
                     */
                    openkampf=true;
                }
                if (feld[neuX][neuY].getTyp() == 2) {
                    if (item.items[1] > 0) {
                        item.items[1] = item.items[1] - 1;
                    } else {
                        return 0;
                    }
                }
                if (feld[neuX][neuY].getTyp() == 7) {
                    kurt.addHP(100);
                }
                if (feld[neuX][neuY].getTyp() == 8) {
                    kurt.addmana(50);
                }
                if (feld[neuX][neuY].getTyp() == 9) {
                    kurt.addXP(50);
                }
                //wand kein movement
                if (feld[neuX][neuY].getTyp() == 0) {
                    return 0;
                }

            }

            kurt.geheZu(neuX, neuY);
            aktY = neuY;
            aktX = neuX;
            feld[aktX][aktY].typ = 1;

            if(openkampf==true){
                return 1;
            }
        }

        return 0;
    }


    public void paint(Graphics g)
    {
        if(inventar==true ){
            schlüssel=item.items[1];
            inv= new Inventar(schlüssel,kurt.getHP(),kurt.getmaxHP(),kurt.getmana(),kurt.getmaxmana(),kurt.getXP(),kurt.getNextLVL(),kurt.getLVL());
            inv.paint(g);
            inventar= false ;
        }else if(openkampf==true) {
            for (int y = 0; y < daten.hoehe; y++)
                for (int x = 0; x < daten.breite; x++)
                    feld[x][y].paint(g);
            kurt.paint(g);
            gegnertyp = 1;
            new_kampf = new new_kampf(kurt.getHP(), kurt.getmaxHP(), kurt.getmana(), kurt.getmaxmana(), kurt.getXP(), kurt.getNextLVL(), kurt.getLVL(), gegnertyp);
            new_kampf.paint(g);
            //Kampf ausführen start
            int k = 1, gegnerHP, gegnerAngriff, angriff = 10;
            if (gegnertyp == 1) {
                gegnerHP = 50;
                gegnerAngriff = 5;
            } else {
                gegnerHP = 0;
                gegnerAngriff = 5;
            }
            while (kurt.leben > 0 && gegnerHP > 0) {
                if (k == 1) {
                    gegnerHP = gegnerHP - kurt.getAngriff();
                    k = 0;
                } else {
                    kurt.leben = kurt.leben - gegnerAngriff;
                    k = 1;
                }
                if (gegnerHP <= 0) {
                    kurt.addXP(100);
                    break;
                } else if (kurt.leben <= 0) {
                    break;
                }
            }
            //Kampf ausführen ende
            openkampf = false;
        }else{
            for (int y = 0; y < daten.hoehe; y++)
                for (int x = 0; x < daten.breite; x++)
                    feld[x][y].paint(g);
            kurt.paint(g);
        }
    }
}
