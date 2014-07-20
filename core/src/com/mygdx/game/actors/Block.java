package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.tools.GameNames;

/**
 * Created by Leo
 * on 28.06.2014.
 */

public class Block extends Actor {

   	private int type;
	private Texture texture;

    public Block(int type) {
        this.type = type;
		this.texture = new Texture(Gdx.files.internal(GameNames.BlockPath.replace("$", String.valueOf(type))));
    }

    @Deprecated @Override
    public void setHeight(float height)
    {
        super.setHeight(height);
    }

    @Deprecated @Override
    public void setWidth(float width)
    {
        super.setWidth(width);
    }

	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(texture,
				this.getX() - texture.getWidth() * 0.5f, this.getY() - texture.getHeight() * 0.5f,
				texture.getWidth() / 2.0f, texture.getHeight() / 2.0f,
				texture.getWidth(), texture.getHeight(),
				1f, 1f,
				this.getRotation(),
				0, 0,
				texture.getWidth(), texture.getHeight(),
				false, false);
	}
}
