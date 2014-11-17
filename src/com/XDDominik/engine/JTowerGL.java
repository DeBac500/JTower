package com.XDDominik.engine;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.XDDominik.editor.JTower_Editor;
import com.XDDominik.game.JTower_Game;

import static org.lwjgl.opengl.GL11.*;

public class JTowerGL {
	private static Main main, back;
	private static boolean switched = false;
	private static long activated = 0;
	
	public static void main(String[] args){
		
		initDisplay();
		initGL();
		initGame();
		
		
		gameLoop();
		
		cleanUp(0);
	}
	
	public static void getInput(){
		if(Keyboard.isKeyDown(Keyboard.KEY_E) && Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && !switched){
			Main t = back;
			back = main;
			main = t;
			switched = true;
			activated = System.currentTimeMillis();
		}
		
		if(System.currentTimeMillis() - activated > 400)
			switched = false;
		main.input();
	}
	
	public static void update(){
		main.update();
	}
	
	public static void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
		
		
		main.render();
		
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
		main = new JTower_Game();
		back = new JTower_Editor();
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
			Mouse.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cleanUp(int stat){
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		System.exit(stat);
	}
}
