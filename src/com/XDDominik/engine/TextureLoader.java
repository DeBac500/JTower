package com.XDDominik.engine;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;


public class TextureLoader {
	private static final int BYTES_PER_PIXEL = 4;//3 for RGB, 4 for RGBA
	
	public static int loadTexture(String path) throws IOException{
		int textureID = glGenTextures();
		
		BufferedImage image = ImageIO.read(new File(path));
		
		int[] pixels = new int[image.getHeight() * image.getWidth()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
		
		int pixel = 0;
		for(int y  = 0;  y < image.getHeight(); y++){
			for(int x  = 0; x < image.getWidth(); x++){
				pixel = pixels[y*image.getWidth() + x];
				buffer.put((byte)  ((pixel >> 16) & 0xFF));
				buffer.put((byte)  ((pixel >> 8) & 0xFF));
				buffer.put((byte)  ((pixel) & 0xFF));
				buffer.put((byte)  ((pixel >> 24) & 0xFF));
			}
		}
		
		buffer.flip();
		
		glBindTexture(GL_TEXTURE_2D, textureID);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		glBindTexture(GL_TEXTURE_2D, 0);
		
		return textureID;
	}

}
