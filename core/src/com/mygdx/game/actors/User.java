package com.mygdx.game.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.game.tools.GameValues;

/**
 * Created by Leo
 * on 20.07.2014.
 */
public class User {
	BodyDef bodyDef;
	Body body;
	CircleShape dynamicCircle;
	FixtureDef fixtureDef;

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
