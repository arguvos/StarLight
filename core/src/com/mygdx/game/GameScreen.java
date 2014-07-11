package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.tools.GameNames;

/**
 * Created by God on 29.06.2014.
 */
public class GameScreen extends AbstractScreen {
    public GameScreen(StarLightGame game) {
        super(game);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show()");
        Gdx.input.setInputProcessor(stage);
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
