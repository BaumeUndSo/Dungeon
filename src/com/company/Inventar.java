package com.company;

import java.awt.*;
public class Inventar {
    int schlüssel,leben,mana,maxleben,maxmana,healpots;
	public Inventar(int pschlüssel,int pleben,int pmaxleben,int pmana,int pmaxmana) {
		schlüssel=pschlüssel;
		leben=pleben;
		mana=pmana;
		maxleben=pmaxleben;
		maxmana=pmaxmana;
	}
public void paint(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(100,100,100,200);
	g.setColor(Color.BLACK);
	g.drawRect(100,100,100,200);

	g.drawString(leben+"/"+maxleben+" HP",110,120);
	g.drawString(mana+"/"+maxmana+" Mana",110,140);
	g.drawString(schlüssel+"x Schlüssel",110,160);
}

}
