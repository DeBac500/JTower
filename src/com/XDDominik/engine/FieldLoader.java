package com.XDDominik.engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;


public class FieldLoader {
	public static Properties imageMapdes;
	public static String path;
	private static HashMap<String, Integer> tids;
	
	public static void initi(){
		initi("com/XDDOminik/gfx/ground");
	}
	
	public static void initi(String path){
		imageMapdes = new Properties();
		try {
			imageMapdes.load(FieldLoader.class.getClassLoader().getResourceAsStream(path + ".properties"));
			FieldLoader.path = path;
			tids = new HashMap<String, Integer>();
		} catch (IOException e) {
			System.err.println("Faild to Load ImageMapdescription");
			e.printStackTrace();
		}
	}
	
	public static int getFieldID(String name){
		if(imageMapdes == null)
			initi();
		if(tids.containsKey(name))
			return tids.get(name);
		try{
			String kor = imageMapdes.getProperty(name);
			String size = imageMapdes.getProperty("bild");
			
			int x = Integer.parseInt(kor.split(";")[0]);
			int y = Integer.parseInt(kor.split(";")[1]);
			int w = Integer.parseInt(size.split(";")[0]);
			int h = Integer.parseInt(size.split(";")[1]);
			return TextureLoader.loadTexture(FieldLoader.class.getClassLoader().getResourceAsStream(path + "."+imageMapdes.getProperty("fileend")),x , y, w, h);
		}catch(IOException e){
			System.err.println("Faild to Load Image");
			//TODO
			e.printStackTrace();
		}catch(NumberFormatException e){
			System.err.println("Faild to Formate Properties");
			//TODO
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String getPro(String key){
		if(imageMapdes == null)
			initi();
		return imageMapdes.getProperty(key);
	}
}
