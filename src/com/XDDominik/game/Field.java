package com.XDDominik.game;

import static org.lwjgl.opengl.GL11.*;

import com.XDDominik.engine.GameObjekt;

public class Field extends GameObjekt{
	private int textureID , w  = 32, h = 32;
	
	public Field(int textureID){
		this.textureID = textureID;
	}
	

	public Field(int textureID , int w, int h){
		this.textureID = textureID;
		this.w = w;
		this.h = h;
	}
	public Field(int textureID, float x , float y){
		super(x, y);
		this.textureID = textureID;
	}
	public Field(int textureID, float x , float y , float sx, float sy){
		super(x, y, sx, sy);
		this.textureID = textureID;
	}
	public Field(int textureID, float x , float y , float sx, float sy , int h, int w){
		super(x, y, sx, sy);
		this.textureID = textureID;
		this.w = w;
		this.h = h;
	}

	@Override
	public void update() {
		this.setX(this.getX() + this.getSx());
		this.setY(this.getY() + this.getSy());
	}

	@Override
	public void render() {
		
		glColor3d(100, 100, 100);
		glBindTexture(GL_TEXTURE_2D, textureID);
		glBegin(GL_QUADS);
		//Links Oben
		glTexCoord2f(0.0f, 0.0f);
		glVertex2f(this.getX(), this.getY());
		//rechts Oben
		glTexCoord2f(1.0f, 0.0f);
		glVertex2f(this.getX() + w, this.getY());
		//rechts unten
		glTexCoord2f(1.0f, 1.0f);
		glVertex2f(this.getX() + w, this.getY() + h);
		//links unten
		glTexCoord2f(0.0f, 1.0f);
		glVertex2f(this.getX() , this.getY() + h);
		
		glEnd();
		glBindTexture(GL_TEXTURE_2D, 0);
		
	}


	@Override
	public void input() {
	}

}
