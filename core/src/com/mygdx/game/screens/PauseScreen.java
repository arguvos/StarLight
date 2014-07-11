package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.StarLightGame;


/**
 * Created by Vasek on 25.06.2014.
 */
public class PauseScreen extends AbstractScreen {

    public PauseScreen(StarLightGame game) {
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
        Label title = new Label("Pause:", skin);
        table.add(title);
        table.row();
        TextButton btnContinue = new TextButton("Continue", skin);
        btnContinue.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Pressed btnContinue");
            }
        });
        TextButton btnExitToMenu = new TextButton("Exit to Menu", skin);
        btnExitToMenu.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Pressed btnExitToMenu");
            }
        });
        table.add(btnContinue);
        table.row();
        table.add(btnExitToMenu);
        stage.addActor(table);
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