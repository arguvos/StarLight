package com.mygdx.game.Physics;

/**
 * Created by God on 06.07.2014.
 */
public class Acceleration {
    public float accelerationX=0;
    public float accelerationY=0;
    public void addAcceleration(Acceleration acceleration)
    {
        accelerationX+=acceleration.accelerationX;
        accelerationY+=acceleration.accelerationY;
    }
}