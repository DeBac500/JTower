package com.XDDominik.engine;

import static org.lwjgl.opengl.GL11.*;

import java.awt.image.BufferedImage;

public class JTower_Game {
	private int textureID;
	public JTower_Game(){
		BufferedImage image = TextureLoader.loadImage("com/XDDOminik/gfx/ground.png");//The path is inside the jar file
		textureID = TextureLoader.loadTexture(image);
		
		
        
	}

	public void getInput() {
		
	}

	public void update() {

	}

	public void render() {
		
		glBindTexture(GL_TEXTURE_2D, textureID);
		
		glBegin(GL_TRIANGLES);
		 
        glTexCoord2f(0.0f, 0.0f);
        glVertex3f(-1.0f, -1.0f, -0.5f);

        glTexCoord2f(1.0f, 0.0f);
        glVertex3f(-0.1f, -1.0f, -0.5f);

        glTexCoord2f(1.0f, 1.0f);
        glVertex3f(-0.1f, +1.0f, -0.5f);

        glEnd();
	}
}
