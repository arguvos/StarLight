package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import com.mygdx.game.StarLightGame;
import com.mygdx.game.input.StarGestureListener;
import com.mygdx.game.input.StarInputProcessor;
import com.mygdx.game.input.ValuesContainer;
import com.mygdx.game.tools.LevelBuilder;
import com.mygdx.game.tools.LevelInfo;
import com.mygdx.game.tools.LevelParser;


public class GameScreen extends AbstractScreen {

	private LevelParser levelParser;
	private LevelInfo levelInfo;
	private LevelBuilder levelBuilder;

	private InputMultiplexer inputMultiplexer;
	private StarGestureListener starGestureListener;
	private StarInputProcessor starInputProcessor;

    private int levelNumber;

	public GameScreen(StarLightGame game) {
		super(game);
	}
    public GameScreen(StarLightGame game, int levelNumber) {
        super(game);
        this.levelNumber = levelNumber;
    }

	@Override
	public void show() {
		super.show();
		initaliseInputProcessors();

		levelParser = new LevelParser();
		levelInfo = levelParser.getLevelInfo(1);
        levelInfo.setLevelNumber(levelNumber);
		levelBuilder = new LevelBuilder();
		levelBuilder.buildLevel(levelInfo, stage);
	}

	public void initaliseInputProcessors() {
		inputMultiplexer = new InputMultiplexer();

		Gdx.input.setInputProcessor(inputMultiplexer);
		starGestureListener = new StarGestureListener(this.camera);
		starInputProcessor = new StarInputProcessor(this.camera);
		inputMultiplexer.addProcessor(new GestureDetector(starGestureListener));
		inputMultiplexer.addProcessor(starInputProcessor);
		inputMultiplexer.addProcessor(stage);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		camera.zoom = ValuesContainer.zoom;
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