package com.XDDominik.game;

import com.XDDominik.engine.Main;


public class JTower_Game implements Main{
	private GameField feld;
	public JTower_Game() {
		feld = new GameField("level_01"); 
//		feld = new GameField(); 
	}

	public void input() {
		feld.input();
	}

	public void update() {
		feld.update();
	}

	public void render() {
		feld.render();
	}
}
