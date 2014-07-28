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
import com.mygdx.game.tools.GameNames;

/**
 * Created by Leo on 25.06.2014.
 */
public class MainMenuScreen extends AbstractScreen {

    private TextureAtlas atlas;
    private Table table;

    public MainMenuScreen(StarLightGame game) {
        super(game);
    }


    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(stage);


        table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        atlas = new TextureAtlas(Gdx.files.internal(GameNames.MainMenuAtlas));
        Skin skin = new Skin();
        skin.addRegions(atlas);

        BitmapFont font = new BitmapFont(Gdx.files.internal("MainMenu/font.fnt"), false);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable(GameNames.MenuBtnPlayOff);
        style.down = skin.getDrawable(GameNames.MenuBtnPlayOn);
        style.font = font;

        skin.add("default", style);
        final TextButton startGameButton = new TextButton("",skin);
        startGameButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Pressed btnPlay");
                game.setGameState(StarLightGame.GameState.LEVEL_SELECT_SCREEN);
                game.setScreen(game.getLevelSelectScreen());
            }
        });
        table.add(startGameButton);
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
