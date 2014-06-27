package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by Leo on 25.06.2014.
 */
public class StarLightGame extends Game {

    @Override
    public void create () {
        setScreen(new MainMenuScreen(this));
    }
}
