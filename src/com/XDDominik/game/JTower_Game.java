package com.XDDominik.game;


public class JTower_Game {
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
