package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.tools.GameNames;

/**
 * Created by Leo
 * on 20.07.2014.
 */
public class User extends Actor{
	BodyDef bodyDef;
	Body body;
	CircleShape dynamicCircle;
	FixtureDef fixtureDef;

	private int type;
	private Texture texture;

	public User(int type) {
		this.type = type;
		this.texture = new Texture(Gdx.files.internal(GameNames.BlockPath.replace("$", String.valueOf(type))));
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

	public BodyDef getBodyDef() {
		return bodyDef;
	}

	public void setBodyDef(BodyDef bodyDef) {
		this.bodyDef = bodyDef;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public CircleShape getDynamicCircle() {
		return dynamicCircle;
	}

	public void setDynamicCircle(CircleShape dynamicCircle) {
		this.dynamicCircle = dynamicCircle;
	}

	public FixtureDef getFixtureDef() {
		return fixtureDef;
	}

	public void setFixtureDef(FixtureDef fixtureDef) {
		this.fixtureDef = fixtureDef;
	}
}
