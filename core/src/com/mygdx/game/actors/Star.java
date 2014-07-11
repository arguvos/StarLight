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

public class Star extends Actor {

    private float mass;
    private float speedX;
    private float speedY;
    private int type;
	private Texture texture;

    public Star(int type, float mass, float speedX, float speedY) {
        this.mass = mass;
        this.speedX = speedX;
        this.speedY = speedY;
        this.type = type;
		this.texture = new Texture(Gdx.files.internal(GameNames.StarPath.replace("$", String.valueOf(type))));
    }

    public Star(int type, float mass) {
        this.mass = mass;
        this.speedX = 0;
        this.speedY = 0;
        this.type = type;
		this.texture = new Texture(Gdx.files.internal(GameNames.StarPath.replace("$", String.valueOf(type))));
    }

	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(	texture,
				this.getX() - texture.getWidth() * 0.5f,
				this.getY() - texture.getHeight() * 0.5f);
	}

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }
}
