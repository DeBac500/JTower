package com.XDDominik.engine;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.lwjgl.input.Keyboard;


public class JTower_Game {
	private int textureID = 0;
	
	private int x = 0, y = 0;
	private int x1 = 0, y1 = 0;
	public JTower_Game() {
		
		try {
			
			textureID = TextureLoader.loadTexture(JTowerGL.class.getClassLoader().getResourceAsStream("com/XDDOminik/gfx/ground.png"));
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
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			x1 -= 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			x1 += 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			y1 -= 5;
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			y1 += 5;
	}

	public void update() {

	}

	public void render() {
		
		
		
		glColor3d(100, 0, 0);
		//glBindTexture(GL_TEXTURE_2D, textureID);
		glBegin(GL_QUADS);
		glTexCoord2f(0.0f, 0.0f);
		glVertex2f(100 + x1, 100 + y1);
		glTexCoord2f(1.0f, 0.0f);
		glVertex2f(100 + 450 + x1, 100 + y1);
		glTexCoord2f(1.0f, 1.0f);
		glVertex2f(100 + 450 + x1, 100 + 190 + y1);
		glTexCoord2f(0.0f, 1.0f);
		glVertex2f(100 + x1, 100 + 190 + y1);
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);
		
		glColor3d(100,100, 100);
		glBindTexture(GL_TEXTURE_2D, textureID);
		//glColor3d(0, 0, 0);
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
		glBindTexture(GL_TEXTURE_2D, 0);
	}
}
