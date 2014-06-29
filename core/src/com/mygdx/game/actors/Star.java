package com.mygdx.game.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Leo on 28.06.2014.
 */
public class Star extends Actor {

    private float mass;
    private float speedX;
    private float speedY;
    private int type;

    public Star(int type, float mass, float speedX, float speedY) {
        this.mass = mass;
        this.speedX = speedX;
        this.speedY = speedY;
        this.type = type;
    }

    public Star(int type, float mass) {
        this.mass = mass;
        this.speedX = 0;
        this.speedY = 0;
        this.type = type;
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
