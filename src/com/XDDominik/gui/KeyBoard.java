package com.XDDominik.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard  implements KeyListener{
	public static boolean[] keys = new boolean[1024];
	
	public static boolean isKeyPressed(int keyCode){
		if(keyCode >= 0 && keyCode < KeyBoard.keys.length) 
			return KeyBoard.keys[keyCode];
		else 
			return false;
	}
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyChar() + " = " + e.getKeyCode());
		if(e.getKeyCode() >= 0 && e.getKeyCode() < KeyBoard.keys.length) KeyBoard.keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() >= 0 && e.getKeyCode() < KeyBoard.keys.length) KeyBoard.keys[e.getKeyCode()] = false;
	}
	
	
	
	
	

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
