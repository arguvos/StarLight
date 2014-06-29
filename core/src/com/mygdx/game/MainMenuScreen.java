package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Created by Leo on 25.06.2014.
 */
public class MainMenuScreen extends AbstractScreen {

	private Table table;
	private TextureAtlas atlas;

	public MainMenuScreen(StarLightGame game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();

		table = new Table();
		table.setFillParent(true);
        table.center();
		stage.addActor(table);

		atlas = new TextureAtlas("MainMenu/testPack.pack");
		Skin skin = new Skin();
		skin.addRegions(atlas);

		BitmapFont font = new BitmapFont(Gdx.files.internal("MainMenu/font.fnt"), false);

		TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
		style.up = skin.getDrawable("on");
		style.down = skin.getDrawable("off");
		style.font = font;

		skin.add("default", style);

		final TextButton startGameButton = new TextButton("Start game", skin);

		startGameButton.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                Gdx.app.log("startGameButton", "changed");
                game.setScreen(new GameScreen(game));
            }
        });
        table.add(startGameButton);
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
