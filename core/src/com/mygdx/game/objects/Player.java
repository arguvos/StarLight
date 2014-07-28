package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.tools.GameNames;
import com.mygdx.game.tools.GameValues;

/**
 * Created by Leo
 * on 26.07.2014.
 */
public class Player extends AbstractGameObject {

	public Player(Body body) {
		super(body);

		Texture texture = new Texture(Gdx.files.internal(GameNames.PlayerPath));
		sprite = new Sprite(texture);
		width = GameValues.BlockDistance * 0.8f; //GameValues.playerWidth;
		height = GameValues.BlockDistance * 0.8f; //GameValues.playerHeight;
        body.setUserData("player");
		textureRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
        String a = (String)body.getUserData();
	}
}
