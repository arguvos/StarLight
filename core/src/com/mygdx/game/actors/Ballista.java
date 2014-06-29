package com.mygdx.game.actors;

import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Stack;

/**
 * Created by Leo on 28.06.2014.
 */
public class Ballista extends Actor {

    private int type;
    private Stack<Planet> planetStack;

    public Ballista() {
        type = 0;
        planetStack = new Stack<Planet>();
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
