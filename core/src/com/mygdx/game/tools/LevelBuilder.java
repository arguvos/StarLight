package com.mygdx.game.tools;


import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Leo on 11.07.2014.
 */
public class LevelBuilder {
	public void buildLevel(LevelInfo levelInfo, Stage stage) {
		stage.addActor(levelInfo.ballista);
	}
}
