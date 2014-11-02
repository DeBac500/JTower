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
	
	public Frame(){
		super("JTower");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
//		setBackground(Color.BLACK);
		setUndecorated(true);
//		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		addKeyListener(new KeyBoard());
		
		
		
	}
	
	public void creatStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	public void repaintScreen() {
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}
	
	private void draw(Graphics g) {
		g.drawImage(images, 10, 10, null);
		
		g.drawImage(image, 10, 200, null);
	}
}
