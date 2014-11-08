package com.XDDominik.game;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.XDDominik.engine.FieldLoader;
import com.XDDominik.engine.GameObjekt;
import com.XDDominik.engine.LevelReader;

//TODO Verbinden der Felder mit gameField cordis
public class GameField extends GameObjekt {
	private Field[][] feld;
	private int x, y, sx, sy;

	public GameField() {
		super(0, 0, 0, 0);
		feld = new Field[25][19];

		int buildid = FieldLoader.getFieldID("build");
		int emptyid = FieldLoader.getFieldID("empty");
		
		String size = FieldLoader.getPro("bild");
		int w = Integer.parseInt(size.split(";")[0]);
		int h = Integer.parseInt(size.split(";")[1]);

		for (int y = 0; y < feld[0].length; y++) {
			for (int x = 0; x < feld.length; x++) {
				
				if (x == 0 || y == 0 || x == feld.length - 1
						|| y == feld[0].length - 1) {
					// Bau field
					feld[x][y] = new Field(buildid, x * w, y * h, 0, 0, h, w);
				} else {
					// Emty Field
					feld[x][y] = new Field(emptyid, x * w, y * h, 0, 0, h, w);
				}
			}
		}
	}

	public GameField(String lvln) {
		super(0, 0, 0, 0);
		try {
			String in = LevelReader.getLevelInfo("level_01");
			feld = new Field[Integer.parseInt(in.split(";")[0])][Integer
					.parseInt(in.split(";")[1])];

			int buildid = FieldLoader.getFieldID("build");
			int emptyid = FieldLoader.getFieldID("empty");
			
			String size = FieldLoader.getPro("bild");
			int w = Integer.parseInt(size.split(";")[0]);
			int h = Integer.parseInt(size.split(";")[1]);

			for (int y = 0; y < feld[0].length; y++) {
				for (int x = 0; x < feld.length; x++) {
					

					switch (LevelReader.getNextField()) {
					case '#':
						//Default return wert
						break;
					case 'E':
						feld[x][y] = new Field(emptyid, x * w, y * h, 0, 0, h, w);
						break;
					case 'B':
						feld[x][y] = new Field(buildid, x * w, y * h, 0, 0, h, w);
						break;
					default:
						break;
					}
				}
			}
			
			int xl = feld[0].length * w;
			int yl = feld.length * h;
			
			this.setX((Display.getWidth() - xl)/2);
			this.setY((Display.getHeight() - yl)/2);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[0].length; y++) {
				feld[x][y].setX(feld[x][y].getX() + sx * -1);
				feld[x][y].setY(feld[x][y].getY() + sy);
			}
		}
		sx = 0;
		sy = 0;
	}

	@Override
	public void render() {
		for (int x = 0; x < feld.length; x++) {
			for (int y = 0; y < feld[0].length; y++) {
				feld[x][y].render();
			}
		}
	}

	@Override
	public void input() {

		if (Mouse.isButtonDown(0)) {
			sx = x - Mouse.getX();
			sy = y - Mouse.getY();
		}
		x = Mouse.getX();
		y = Mouse.getY();
	}
}
