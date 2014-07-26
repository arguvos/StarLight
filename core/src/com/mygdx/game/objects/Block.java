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
public class Block extends AbstractGameObject {

	public int type = 1;

	public Block(Body body, int type) {
		super(body);
		this.type = type;

		Texture texture = new Texture(Gdx.files.internal(GameNames.BlockPath.replace("$", String.valueOf(type))));
		sprite = new Sprite(texture);
		width = GameValues.BlockDistance;
		height = GameValues.BlockDistance;
		textureRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
	}
}
