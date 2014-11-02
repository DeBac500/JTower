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
		
		Frame f = new Frame();
		
		DisplayMode displayMode = new DisplayMode(Frame.width, Frame.height, Frame.bit, Frame.refrash);
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		
		device.setFullScreenWindow(f);
		device.setDisplayMode(displayMode);
		
		f.creatStrat();
		
		long lastFrame = System.currentTimeMillis();
		while(true){
			
			if(KeyBoard.isKeyPressed(KeyEvent.VK_ESCAPE))
				//TODO besser beenden
				System.exit(0);
			
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = ((float)(thisFrame-lastFrame))/1000f;
			lastFrame=thisFrame;
			
			
			f.repaintScreen();
		}
	}
}
