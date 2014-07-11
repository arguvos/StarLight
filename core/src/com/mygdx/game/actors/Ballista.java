package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.tools.GameNames;

import java.util.Stack;

/**
 * Created by Leo on 28.06.2014.
 */
public class Ballista extends Actor {

    private int type;
    private Stack<Planet> planetStack;
	private Texture texture;
	private float distance;

    public Ballista() {
		type = 0;
		planetStack = new Stack<Planet>();
	}

	public Ballista(int type) {
		this.type = type;
		planetStack = new Stack<Planet>();
		distance = -20;
		this.texture = new Texture(Gdx.files.internal(GameNames.BallistaPath.replace("$", String.valueOf(type))));
	}

	public Ballista(Texture texture, float pointsDistance) {
		type = 0;
		planetStack = new Stack<Planet>();
		this.texture = texture;
		distance = pointsDistance;
	}

	@Override
	public void draw(Batch batch, float alpha){
		batch.draw(	texture,
					this.getX() - texture.getWidth() * 0.5f,
					this.getY() - texture.getHeight() * 0.5f);
	}

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void addPlanet(Planet planet) {
        planetStack.push(planet);
    }

    public Planet popPlanet() {
        return planetStack.pop();
    }

    public int planetsCount() {
        return planetStack.size();
    }
}
