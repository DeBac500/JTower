package com.XDDominik.game;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.XDDominik.gui.Frame;
import com.XDDominik.gui.KeyBoard;

public class JTower {
	
	public static void main(String[] args){
//		for (DisplayMode dm : GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayModes()) {
//			System.out.println("DisplayMode: " + dm.getWidth() + "x" + dm.getHeight() + " - " + dm.getBitDepth() + "---" + dm.getRefreshRate());
//		}
		
		
		DisplayMode displayMode = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayModes()[0];
//		DisplayMode displayMode = new DisplayMode(Frame.width, Frame.height, Frame.bit, Frame.refrash);
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		
		Frame f = new Frame(displayMode.getWidth(), displayMode.getHeight());
		//f.addKeyListener(new KeyBoard());
		
		device.setFullScreenWindow(f);
		device.setDisplayMode(displayMode);
		
		f.setVisible(false);
		f.setVisible(true);
		
//		device.getFullScreenWindow().addKeyListener(new KeyBoard());
		
		f.creatStrat();
		
		
		System.out.println("Vor");
		long lastFrame = System.currentTimeMillis();
		while(true){
			if(KeyBoard.isKeyPressed(KeyEvent.VK_ESCAPE))
				//TODO besser beenden
				System.exit(0);
			
			if(KeyBoard.isKeyPressed(KeyEvent.VK_A))
				System.exit(0);
			if(KeyBoard.isKeyPressed(KeyEvent.VK_D))
				f.move();
			
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			
			f.repaintScreen();
		}
	}
}
