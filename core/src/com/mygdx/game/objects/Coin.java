package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.tools.GameNames;
import com.mygdx.game.tools.GameValues;

/**
 * Created by sergey on 27.07.14.
 */
public class Coin extends AbstractGameObject {
    public Coin(Body body) {
        super(body);
        Texture texture = new Texture(Gdx.files.internal(GameNames.CoinPath));

        sprite = new Sprite(texture);
        width = GameValues.coinWidth;
        height = GameValues.coinHeight;
        body.setUserData("coin");
        textureRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
