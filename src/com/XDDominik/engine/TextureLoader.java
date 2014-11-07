package com.XDDominik.engine;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;


public class TextureLoader {

	private static final int BYTES_PER_PIXEL = 4;//3 for RGB, 4 for RGBA
	
	public static int loadTexture(InputStream path , int x, int y , int w, int h) throws IOException{
		int textureID = glGenTextures();
		
		BufferedImage image = ImageIO.read(path);
		
		int[] pixels = new int[h * w];
		pixels = image.getRGB(x, y, w, h, pixels, 0, w);
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(w * h * 4);
		
		int pixel = 0;
		for(int y1  = 0;  y1 < h; y1++){
			for(int x1  = 0; x1 < w; x1++){
				pixel = pixels[y1*w + x1];
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
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, w, h, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		glBindTexture(GL_TEXTURE_2D, 0);
		
		return textureID;
	}
	
	public static int loadTexture(String path, int x, int y , int w, int h) throws IOException{
		return loadTexture(new FileInputStream(new File(path)),  x,  y ,  w,  h);
	}

}
