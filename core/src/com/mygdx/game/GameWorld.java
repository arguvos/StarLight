package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.screens.AbstractScreen;

/**
 * Created by Leo
 * on 19.07.2014.
 */
public class GameWorld {
	private Stage stage;
	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;

	public GameWorld() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AbstractScreen.CAMERA_WIDTH,  AbstractScreen.CAMERA_HEIGHT);
		viewport = new ScreenViewport(camera);
		this.stage = new Stage(viewport);
	}

	public Stage getStage() {
		return stage;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void render(float delta) {
		stage.act(delta);
		batch.setProjectionMatrix(camera.view);
		batch.begin();
		stage.draw();
		batch.end();
	}
}
