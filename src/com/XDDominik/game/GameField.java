package com.XDDominik.game;

import org.lwjgl.input.Mouse;

import com.XDDominik.engine.FieldLoader;
import com.XDDominik.engine.GameObjekt;

public class GameField extends GameObjekt{
	private Field[][] feld;
	private int x, y , sx , sy;
	public GameField(){
		super(0, 0, 0, 0);
		feld = new Field[25][19];
		
		int buildid = FieldLoader.getFieldID("build");
		int emptyid = FieldLoader.getFieldID("empty");
		
		for(int x = 0; x < feld.length; x++){
			for(int y = 0; y < feld[0].length; y++){
				String size = FieldLoader.getPro("bild");
				int w = Integer.parseInt(size.split(";")[0]);
				int h = Integer.parseInt(size.split(";")[1]);
				if (x == 0 || y == 0 || x == feld.length-1 || y == feld[0].length-1 || x%4 == 0){
					//Bau field
					feld[x][y] = new Field(buildid, x * w, y * h, 0, 0, h, w);
				}else{
					//Emty Field
					feld[x][y] = new Field(emptyid, x * w, y * h, 0, 0, h, w);
				}
			}
		}
	}

	@Override
	public void update() {
		for(int x = 0; x < feld.length; x++){
			for(int y = 0; y < feld[0].length; y++){
				feld[x][y].setX(feld[x][y].getX() + sx *-1);
				feld[x][y].setY(feld[x][y].getY() + sy);
			}
		}
		sx = 0;
		sy = 0;
	}

	@Override
	public void render() {
		for(int x = 0; x < feld.length; x++){
			for(int y = 0; y < feld[0].length; y++){
				feld[x][y].render();
			}
		}
	}

	@Override
	public void input() {
		
		if (Mouse.isButtonDown(0)) {
            sx = x-Mouse.getX();
            sy = y-Mouse.getY();
		}
		x = Mouse.getX();
		y = Mouse.getY();
	}
}
