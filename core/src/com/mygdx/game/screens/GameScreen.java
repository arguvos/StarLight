package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.StarLightGame;
import com.mygdx.game.tools.LevelBuilder;
import com.mygdx.game.tools.LevelInfo;
import com.mygdx.game.tools.LevelParser;


public class GameScreen extends AbstractScreen {

	private LevelParser levelParser;
	private LevelInfo levelInfo;
	private LevelBuilder levelBuilder;

	public GameScreen(StarLightGame game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		Gdx.input.setInputProcessor(stage);

		levelParser = new LevelParser();
		levelInfo = levelParser.getLevelInfo(1);
		levelBuilder = new LevelBuilder();
		levelBuilder.buildLevel(levelInfo, stage);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}