package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.Block;
import com.mygdx.game.objects.Coin;
import com.mygdx.game.screens.AbstractScreen;
import com.mygdx.game.tools.LevelInfo;

import java.util.Iterator;

/**
 * Created by Leo
 * on 19.07.2014.
 */
public class GameWorld{
	private Stage stage;
	private OrthographicCamera camera;
	private Viewport viewport;
	private SpriteBatch batch;

	private World boxWorld;
	private Box2DDebugRenderer debugRenderer;

	private LevelInfo levelInfo;

	public GameWorld() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, AbstractScreen.CAMERA_WIDTH, AbstractScreen.CAMERA_HEIGHT);
		viewport = new ExtendViewport(10, 10, camera);
		this.stage = new Stage(viewport);
		boxWorld = new World(new Vector2(0, 0), true);
		debugRenderer = new Box2DDebugRenderer();
        boxWorld.setContactListener(new GameContactListener(boxWorld));
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo levelInfo) {
		this.levelInfo = levelInfo;
	}

	public Stage getStage() {
		return stage;
	}

	public World getWorld() {
		return boxWorld;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void render(float delta) {
		stage.act(delta);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
//		stage.draw();
		levelInfo.player.render(batch);
		for(Block b : levelInfo.getBlocks()) {
			b.render(batch);
		}


        Iterator<Coin> coinsIterator =  levelInfo.getCoins().iterator();
        while ( coinsIterator.hasNext() ) {
            Coin c = coinsIterator.next();
             if (  c.getBody().getUserData() != null )
                c.render(batch);
             else
                 coinsIterator.remove();
        }
		batch.end();

		debugRenderer.render(boxWorld, camera.combined);
		boxWorld.step(1/60f, 6, 2);

//		Gdx.app.log("camera", String.valueOf(camera.viewportWidth));
	}
}
