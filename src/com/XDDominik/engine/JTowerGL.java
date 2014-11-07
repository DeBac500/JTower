package com.XDDominik.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class JTowerGL {
	private static JTower_Game game;
	
	public static void main(String[] args){
		
		initDisplay();
		initGL();
		initGame();
		
		
		gameLoop();
		
		cleanUp(0);
	}
	
	public static void getInput(){
		game.getInput();
	}
	
	public static void update(){
		game.update();
	}
	
	public static void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		
		game.render();
		
		Display.update();
		Display.sync(60);
	}
	
	public static void gameLoop(){
		while(!Display.isCloseRequested()){
			getInput();
			update();
			render();
		}
	}
	
	public static void initGame(){
		game = new JTower_Game();
	}
	
	public static void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(),Display.getHeight(), 0, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		
		glClearColor(0, 0, 0, 0);
	}
	
	public static void initDisplay(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("JTower :D");
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cleanUp(int stat){
		Display.destroy();
		Keyboard.destroy();
		System.exit(stat);
	}
}
