package com.XDDominik.editor;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import com.XDDominik.engine.GameObjekt;

public class Edit_Field extends GameObjekt{
	private int w = 32 , h = 32;
	public Edit_Field(int x, int y){
		super(x,y);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render() {
		glColor3d(100, 0, 0);
		glBindTexture(GL_TEXTURE_2D, 0);
		glBegin(GL_QUADS);
		//Links Oben
//		glTexCoord2f(0.0f, 0.0f);
		glVertex2f(this.getX(), this.getY());
		//rechts Oben
//		glTexCoord2f(1.0f, 0.0f);
		glVertex2f(this.getX() + w, this.getY());
		//rechts unten
//		glTexCoord2f(1.0f, 1.0f);
		glVertex2f(this.getX() + w, this.getY() + h);
		//links unten
//		glTexCoord2f(0.0f, 1.0f);
		glVertex2f(this.getX() , this.getY() + h);
		
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		
	}

}
