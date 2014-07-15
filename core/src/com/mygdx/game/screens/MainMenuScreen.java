package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.mygdx.game.StarLightGame;

/**
 * Created by Leo on 25.06.2014.
 */
public class MainMenuScreen extends AbstractScreen {
	public MainMenuScreen(StarLightGame game) {
		super(game);
	}

	@Override
	public void show() {
		super.show();
		Gdx.input.setInputProcessor(stage);
		Skin skin = new Skin(Gdx.files.internal("Menu/uiskin.json"));
		Table table = new Table();
		table.setFillParent(true);
		table.center();
		Label title = new Label("Star Light", skin);
		table.add(title);
		table.row();
		TextButton btnPlay = new TextButton("Play", skin);
		btnPlay.addListener(new ChangeListener() {
		    public void changed (ChangeEvent event, Actor actor) {
			System.out.println("Pressed btnPlay");
			game.setScreen(new LevelSelectScreen(game,30,2));
		    }
		});        
		table.add(btnPlay);
		table.row();
		stage.addActor(table);
		camera.zoom = 1.f;
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
