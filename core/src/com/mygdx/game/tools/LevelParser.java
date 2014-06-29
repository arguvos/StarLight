package com.mygdx.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.XmlReader;
import com.mygdx.game.actors.Ballista;
import com.mygdx.game.actors.GZone;
import com.mygdx.game.actors.Planet;
import com.mygdx.game.actors.Star;

import java.io.IOException;

/**
 * Created by Leo on 28.06.2014.
 */
public class LevelParser {
	public LevelInfo getLevelInfo(int level) {
		try {
			XmlReader.Element root = new XmlReader().parse(Gdx.files.internal(GameNames.LevelXmlPath
					.replace("$", String.valueOf(level))));

			LevelInfo levelInfo = new LevelInfo();
			levelInfo.description = root.getChildByName("description").getText();
			levelInfo.cameraX = Integer.valueOf(root.getChildByName("camera").getAttribute("startX"));
			levelInfo.cameraY = Integer.valueOf(root.getChildByName("camera").getAttribute("startY"));

			XmlReader.Element bElement = root.getChildByName("ballista");
			Ballista ballista = new Ballista();
			ballista.setPosition(Float.parseFloat(bElement.getAttribute("posX")),
					Float.parseFloat(bElement.getAttribute("posY")));
			for (int i = 0; i < bElement.getChildCount(); ++i) {
                XmlReader.Element pElement = bElement.getChild(i);
                Planet planet = new Planet(
                    Integer.parseInt(pElement.getAttribute("type")),
                    Float.parseFloat(pElement.getAttribute("mass"))
                );
                ballista.addPlanet(planet);
            }
			levelInfo.setBallista(ballista);

            XmlReader.Element psElement = root.getChildByName("planets");
            for (int i = 0; i < psElement.getChildCount(); ++i) {
                XmlReader.Element pElement = psElement.getChild(i);
                Planet planet = new Planet(
                    Integer.parseInt(pElement.getAttribute("type")),
                    Float.parseFloat(pElement.getAttribute("mass")),
                    Float.parseFloat(pElement.getAttribute("speedX")),
                    Float.parseFloat(pElement.getAttribute("speedY"))
                );
                planet.setPosition(
                    Float.parseFloat(pElement.getAttribute("posX")),
                    Float.parseFloat(pElement.getAttribute("posY"))
                );
                levelInfo.addPlanet(planet);
            }

            XmlReader.Element ssElement = root.getChildByName("stars");
            for (int i = 0; i < ssElement.getChildCount(); ++i) {
                XmlReader.Element sElement = ssElement.getChild(i);
                Star star = new Star(
                        Integer.parseInt(sElement.getAttribute("type")),
                        Float.parseFloat(sElement.getAttribute("mass"))
                );
                star.setPosition(
                        Float.parseFloat(sElement.getAttribute("posX")),
                        Float.parseFloat(sElement.getAttribute("posY"))
                );
                levelInfo.addStar(star);
            }

            XmlReader.Element gzElement = root.getChildByName("green_zone");
            for (int i = 0; i < gzElement.getChildCount(); ++i) {
                XmlReader.Element zElement = gzElement.getChild(i);
                GZone zone = new GZone(
                        Integer.parseInt(zElement.getAttribute("type")),
                        Float.parseFloat(zElement.getAttribute("rad")),
                        Float.parseFloat(zElement.getAttribute("width"))
                );
                zone.setPosition(
                        Float.parseFloat(zElement.getAttribute("posX")),
                        Float.parseFloat(zElement.getAttribute("posY"))
                );
                levelInfo.addZone(zone);
            }

            return levelInfo;
		} catch(IOException e) {
			e.printStackTrace();
		}

        return null;
	}
}
