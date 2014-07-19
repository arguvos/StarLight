package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.StarLightGame;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 1024;
        settings.maxHeight = 1024;
        settings.paddingX = 2;
        settings.paddingY = 2;
        settings.combineSubdirectories = true;

        TexturePacker.process(settings, "./Resources/", "./Resources/", "Resources.atlas");
        TexturePacker.process(settings, "./MainMenu/", "./MainMenu/", "MainMenu.atlas");
		new LwjglApplication(new StarLightGame(), config);
	}
}
