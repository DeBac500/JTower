package com.XDDominik.editor;

import java.util.LinkedList;

import org.lwjgl.input.Mouse;

import com.XDDominik.engine.Main;

public class JTower_Editor implements Main{
	private LinkedList<LinkedList<Edit_Field>> feld;
	private int x, y, sx, sy;
	
	public JTower_Editor(){
		feld = new LinkedList<LinkedList<Edit_Field>>();
		feld.add(new LinkedList<Edit_Field>());
		feld.get(0).addLast(new Edit_Field(0,0));
		feld.get(0).addFirst(new Edit_Field(-32,0));
		feld.get(0).addLast(new Edit_Field(32,0));
		feld.addLast(new LinkedList<Edit_Field>());
		feld.get(1).addLast(new Edit_Field(0,32));
	}

	@Override
	public void update() {
		for (int x = 0; x < feld.size(); x++) {
			for (int y = 0; y < feld.get(x).size(); y++) {
				feld.get(x).get(y).setX(feld.get(x).get(y).getX() + sx * -1);
				feld.get(x).get(y).setY(feld.get(x).get(y).getY() + sy);
			}
		}
		sx = 0;
		sy = 0;
	}

	@Override
	public void render() {
		for(LinkedList<Edit_Field> list : feld){
			for(Edit_Field e : list){
				e.render();
			}
		}
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		if (Mouse.isButtonDown(0)) {
//			sx = x - Mouse.getX();
//			sy = y - Mouse.getY();
			sx = Mouse.getDX() * -1;
			sy = Mouse.getDY() * -1;
		}
//		x = Mouse.getX();
//		y = Mouse.getY();
		
//		System.out.println("Mouse x: " + Mouse.getX() + " | " +Mouse.getDX() );
//		System.out.println("Mouse y: " + Mouse.getY() + " | " +Mouse.getDY() );
	}

}
