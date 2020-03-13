package com.company;

public class DungeonDaten
{
    public String[] daten;
    public int breite, hoehe;
    
    public DungeonDaten()
    {
       breite = 17; 
       hoehe  = 16;
       daten = new String[hoehe];       
       //           12345678901234567
       //                    1
       daten[ 0] = "WWWWWWWWWWWWWWWWW";
       daten[ 1] = "W  S       W  I W";
       daten[ 2] = "W          W    W";
       daten[ 3] = "W          W    W";       
       daten[ 4] = "W          W    W";
       daten[ 5] = "W          V    W";
       daten[ 6] = "W          W    W";
       daten[ 7] = "WI         W    W";       
       daten[ 8] = "W          W    W";
       daten[ 9] = "WWWWWWWWWWWW    W";
       daten[10] = "W          W    W";
       daten[11] = "W          V    W";       
       daten[12] = "W          WWWWWW";
       daten[13] = "W          W     ";
       daten[14] = "W          W     ";
       daten[15] = "WWWWWWWWWWWW     ";            
    }

}
