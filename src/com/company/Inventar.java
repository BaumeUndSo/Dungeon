package com.company;

import java.awt.*;
public class Inventar {
    int schlüssel,leben,mana,maxleben,maxmana,healpots,erfahrung,nextLVL,LVL;
	public Inventar(int pschlüssel,int pleben,int pmaxleben,int pmana,int pmaxmana,int perfahrung,int pnextLVL,int pLVL) {
		schlüssel=pschlüssel;
		leben=pleben;
		mana=pmana;
		maxleben=pmaxleben;
		maxmana=pmaxmana;
		erfahrung=perfahrung;
		nextLVL=pnextLVL;
		LVL=pLVL;
	}
public void paint(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(100,100,100,200);
	g.setColor(Color.BLACK);
	g.drawRect(100,100,100,200);

	g.drawString("Du bist Level "+LVL,110,120);
	g.drawString(erfahrung+"/"+nextLVL+" XP",110,140);
	g.drawString(leben+"/"+maxleben+" HP",110,160);
	g.drawString(mana+"/"+maxmana+" Mana",110,180);
	g.drawString(schlüssel+"x Schlüssel",110,200);
}

}
