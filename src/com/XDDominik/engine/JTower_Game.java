package com.XDDominik.engine;

import static org.lwjgl.opengl.GL11.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

public class JTower_Game {
	private int textureID = 0;
	
	private int x = 0, y = 0;
	public JTower_Game() {
		
		try {
			textureID = TextureLoader.loadTexture(System.getProperty("user.dir") + "\\src\\com\\XDDominik\\gfx\\ground.png");
		} catch (IOException e) {
			e.printStackTrace();
			JTowerGL.cleanUp(1);
		}
		
        
	}

	public void getInput() {
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
			x -= 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
			x += 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
			y -= 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
			y += 5;
	}

	public void update() {

	}

	public void render() {
		
		glBindTexture(GL_TEXTURE_2D, textureID);
		glBegin(GL_QUADS);
		glTexCoord2f(0.0f, 0.0f);
		glVertex2f(100 + x, 100 + y);
		glTexCoord2f(1.0f, 0.0f);
		glVertex2f(100 + 450 + x, 100 + y);
		glTexCoord2f(1.0f, 1.0f);
		glVertex2f(100 + 450 + x, 100 + 190 + y);
		glTexCoord2f(0.0f, 1.0f);
		glVertex2f(100 + x, 100 + 190 + y);
		glEnd();
	}
}
