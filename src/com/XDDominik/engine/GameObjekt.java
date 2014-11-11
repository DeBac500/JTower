package com.XDDominik.engine;

public abstract class GameObjekt {
	private float x,y,sx,sy;
	
	public GameObjekt(){
		this.x = 0;
		this.y = 0;
		this.sx = 0;
		this.sy = 0;
	}
	
	public GameObjekt(float x , float y){
		this.x = x;
		this.y = y;
		this.sx = 0;
		this.sy = 0;
	}
	
	public GameObjekt(float x , float y, float sx , float sy){
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
	}
	
	public abstract void update();
	
	public abstract void render();
	
	public abstract void input();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSx() {
		return sx;
	}

	public void setSx(float sx) {
		this.sx = sx;
	}

	public float getSy() {
		return sy;
	}

	public void setSy(float sy) {
		this.sy = sy;
	}
}
