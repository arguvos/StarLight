package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.tools.GameNames;

public abstract class AbstractScreen implements Screen {

    public static final int CAMERA_WIDTH = 1000, CAMERA_HEIGHT = 1000;

	protected final StarLightGame game;
	protected final Stage stage;
    protected final Viewport viewport;
    protected final OrthographicCamera camera;
    protected final SpriteBatch batch;

	public AbstractScreen(StarLightGame game) {
		this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        viewport = new ScreenViewport(camera);
        this.stage = new Stage(viewport);
	}

	@Override
	public void show() {
        Gdx.app.log("AbstractScreen", "show()");
        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
        Gdx.app.log("AbstractScreen", "resize()");

	}

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);

        batch.setProjectionMatrix(camera.view);
        batch.begin();
        stage.draw();
        batch.end();
	}

	@Override
	public void hide() {
        Gdx.app.log("AbstractScreen", "hide()");

	}

	@Override
	public void pause() {
        Gdx.app.log("AbstractScreen", "pause()");

	}

	@Override
	public void resume() {
        Gdx.app.log("AbstractScreen", "resume()");

	}

	@Override
	public void dispose() {
        Gdx.app.log("AbstractScreen", "dispose()");
        batch.dispose();
        stage.dispose();
	}
}
