package com.company;
import java.util.Random;

public class DungeonDaten
{
    public String[] daten;
    public int breite, hoehe, raume;
    
    public DungeonDaten()
    {
        //Hoehe * 4, Breite * 4, Raume,
       int manual=0,gesetzt=0;

       if(manual==0) {
           String mapcode="4-6-3";
           String[] split = mapcode.split("-");
           hoehe=Integer.parseInt(split[0]);
           if(hoehe>6){
               hoehe=6;
           }
           breite=Integer.parseInt(split[1])*4;
           if(breite>6){
               breite=6;
           }
           raume=Integer.parseInt(split[2]);
           if(raume>4){
               raume=4;
           }else if(breite<=2 || hoehe<=2){
               raume=1;
           }
           hoehe=hoehe*4;
           breite=breite*4;
           daten = new String[hoehe];
           for(int h=0; h<hoehe;h++) {
               daten[h]="";
               for (int b = 0; b < breite; b++) {
                   gesetzt=0;
                   //Seiten fest Wände setzen
                   if(h==0 || h==(hoehe-1) || b==0 || b==(breite-1)){
                        daten[h]+="W";
                        gesetzt=1;
                   }else {
                       //Startpunkt immer oben Links
                       if(h==1 && b==1){
                           daten[h]+="S";
                           gesetzt=1;
                           //Endpunkt Tür
                       }else if(h==(hoehe-3) && b==1){
                           daten[h]+="V";
                           gesetzt=1;
                           //Ende des Levels
                       }else if(h==(hoehe-2) && b==1){
                           daten[h]+="N";
                           gesetzt=1;
                           //Wand um endpunkt
                       }else if((h==(hoehe-2) && b==2)||(h==(hoehe-3) && b==2)){
                           daten[h]+="W";
                           gesetzt=1;
                       }else {
                           //raumgenerierung
                           if(raume>=2){
                               if(h==((hoehe/2))){
                                   if(b==(breite-(breite/4))) {
                                       daten[h] += "V";
                                       gesetzt = 1;
                                   }else{
                                       daten[h] += "W";
                                       gesetzt = 1;
                                   }
                               }
                               //Schlüssel oben links
                               if(b==(breite/5) && h==(hoehe/3)) {
                                   daten[h] += "I";
                                   gesetzt = 1;
                               }
                               //Schlüssel unten links
                               if(b==(breite/3) && h==(hoehe-(hoehe/3))) {
                                   daten[h] += "I";
                                   gesetzt = 1;
                               }
                               if(raume>=3) {
                                   if (h <= ((hoehe / 2)) && b==(breite/2)) {
                                       if(h==(hoehe/4)) {
                                           daten[h] += "V";
                                           gesetzt = 1;
                                       }else{
                                           daten[h] += "W";
                                           gesetzt = 1;
                                       }
                                   }
                                   //Schlüssel oben rechts
                                   if(b==(breite-(breite/5)) && h==(hoehe/6)) {
                                       daten[h] += "I";
                                       gesetzt = 1;
                                   }
                                   if(raume>=4) {
                                       if (h >= ((hoehe / 2)) && b==((breite/2)-1)) {
                                           if(h==(hoehe-(hoehe/4))) {
                                               daten[h] += "V";
                                               gesetzt = 1;
                                           }else{
                                               daten[h] += "W";
                                               gesetzt = 1;
                                           }
                                       }
                                       //Schlüssel unten rechts
                                       if(b==(breite-(breite/6)) && h==(hoehe-(hoehe/6))) {
                                           daten[h] += "I";
                                           gesetzt = 1;
                                       }
                                   }
                               }
                           }else{
                               if(b==(breite-(breite/4)) && h==(hoehe-(hoehe/3))) {
                                   daten[h] += "I";
                                   gesetzt = 1;
                               }
                           }
                       }
                   }
                   //wenn nix gesetzt zufällig entscheiden welches Feld gesetzt wird
                   if(gesetzt==0){
                       Random rand = new Random();
                       int randZahl;

                       randZahl = 1 + rand.nextInt(100);
                       //Fähigkeitenpunkt
                       if(randZahl>=95){
                           daten[h] += "H";
                           //starker Gegner
                       }else if(randZahl>=85){
                           daten[h] += "E";
                           //schwacher Gegner
                       }else if(randZahl>=65){
                           daten[h] += "G";
                           //Leerfeld
                       }else{
                           daten[h] += "L";
                       }
                   }
               }
           }

       }else{
           breite = 17;
           hoehe = 16;
           daten = new String[hoehe];
           //           12345678901234567
           //                    1
           daten[0] = "WWWWWWWWWWWWWWWWW";
           daten[1] = "W  S       W  I W";
           daten[2] = "W  H       W    W";
           daten[3] = "W          W    W";
           daten[4] = "W  E       W    W";
           daten[5] = "W          V    W";
           daten[6] = "W          W    W";
           daten[7] = "WI         W    W";
           daten[8] = "W          W    W";
           daten[9] = "WWWWWWWWWWWW    W";
           daten[10] = "W          W    W";
           daten[11] = "W          V    W";
           daten[12] = "W          WWWWWW";
           daten[13] = "W          W     ";
           daten[14] = "W          W     ";
           daten[15] = "WWWWWWWWWWWW     ";
       }
    }

}
