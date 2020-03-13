package com.company;

import java.awt.*;
public class Inventar {
    int schlüssel,healpots;
	public Inventar(int pschlüssel) {
	 schlüssel=pschlüssel;
	}
public void paint(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(100,100,100,200);
	g.setColor(Color.BLACK);
	g.drawRect(100,100,100,200);
	
	g.drawString(schlüssel+"x Schlüssel",110,120);
}

}
