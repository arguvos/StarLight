package com.mygdx.game.tools;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actors.Star;

/**
 * Created by Leo
 * on 11.07.2014.
 */

public class LevelBuilder {
	public void buildLevel(LevelInfo levelInfo, Stage stage) {
		stage.addActor(levelInfo.ballista);
		for (Star star : levelInfo.getStars()) {
			stage.addActor(star);
		}
	}
}
