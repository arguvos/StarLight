package com.mygdx.game.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Leo on 28.06.2014.
 */
public class GZone extends Actor {

    public float zone_width;
    public float radius;
    public int type;

    public GZone(int type, float radius, float zone_width) {
        this.zone_width = zone_width;
        this.radius = radius;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getZone_width() {
        return zone_width;
    }

    public void setZone_width(float zone_width) {
        this.zone_width = zone_width;
    }
}
