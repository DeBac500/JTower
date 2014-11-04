package com.XDDominik.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame extends JFrame{
	public static final int width = 800, height = 600, bit = 16, refrash = 60;
	static BufferedImage image;
	static BufferedImage images;
	static{
		try {
			image = ImageIO.read(Frame.class.getClassLoader().getResourceAsStream("com/XDDOminik/gfx/ground.png"));
			
			images = new BufferedImage(32, 32, image.getType());
			
			Graphics2D gr = images.createGraphics();
			gr.drawImage(image, 0, 0, 32, 32, 160, 0, 160+32, 32, null);
            gr.dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private BufferStrategy strat;
	private int move = 0;
	
	public Frame(int width , int heigt){
		super("JTower");
		//
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, heigt);
//		setBackground(Color.BLACK);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		addKeyListener(new KeyBoard());
//		requestFocus();
	}
	
	public void creatStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	public void  move(){
		move += 5;
	}
	
	public void repaintScreen() {
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
//		repaint();
	}
	
	private void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(images, 100 + move, 10, null);
		
		g.drawImage(image, 10 +move, 200, null);
	}
}
