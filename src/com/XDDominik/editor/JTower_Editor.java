package com.XDDominik.editor;

import java.util.LinkedList;

import com.XDDominik.engine.Main;

public class JTower_Editor implements Main{
	private LinkedList<LinkedList<Edit_Field>> feld;
	
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
		// TODO Auto-generated method stub
		
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
		
	}

}
