package com.mygdx.game.Physics;

/**
 * Created by God on 09.07.2014.
 */
/* во время написания родился и исчез данный класс, возможно пригодиться */
public class Force {
    public float forceX=0;
    public float forceY=0;
    public void addForce(Force force)
    {
        forceX+=force.forceX;
        forceY+=force.forceY;
    }
}
