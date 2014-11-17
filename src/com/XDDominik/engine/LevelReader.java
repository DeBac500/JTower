package com.XDDominik.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LevelReader {
	private static Properties level;
	private static String lev;
	private static int anz = -1;
	private static char c = '#';
	
	public static String getLevelInfo(String levelname){
		lev = null;
		level = new Properties();
		try {
			level.load(new FileInputStream(System.getProperty("user.dir") + "/Level/" + levelname + ".properties"));
			lev = level.getProperty("level");
//			System.out.println(lev);
			return level.getProperty("size");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static char getNextField(){
		if(lev != null){
			if(anz > 0){
				anz --;
				return c;
			}else{
				setNext();
				anz --;
				return c;
			}
		}
		return '#';
	}
	
	private static void setNext(){
		anz = 0;
		for(int i = 0; i < lev.length(); i++){
			if(Character.isDigit(lev.charAt(i))){
				anz = 10*anz + (Character.getNumericValue(lev.charAt(i)));
			}else{
				c = lev.charAt(i);
				lev = lev.substring(i+1);
				break;
			}
		}
	}
}
