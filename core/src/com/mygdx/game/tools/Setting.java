package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Vasek on 13.07.2014.
 */
public class Setting {
	private static Preferences prefs=Gdx.app.getPreferences("Preferences");
	
	public static void setSound(boolean ctrl) {
		prefs.putBoolean("sound", ctrl);
		prefs.flush();
	}
	
	public static boolean getSound() {
		return prefs.getBoolean("sound");		
	}
	
	public static void setHighscore(int score) {
		prefs.putInteger("score", score);
		prefs.flush();
	}
	
	public static int getHighscore() {
		return prefs.getInteger("score");
	}	
}
