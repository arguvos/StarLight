package com.mygdx.game.Physics;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.Planet;
import com.mygdx.game.actors.Star;

/**
 * Created by God on 30.06.2014.
 */
public class Physics {
    private  final float G = 0.0000000000667545F;
    private Array<Planet> planets;
    private Array<Star> stars;
    private float interval;
    private float timeOfLatsUpdate;
    public Physics(Array<Planet> planets,Array<Star> stars, int updatesInSecond)
    {
        this.planets=planets;
        this.stars=stars;
        interval=1F/updatesInSecond;
        timeOfLatsUpdate=0;
    }
    private Acceleration getAccelerationToStars(Planet planet)
    {
        float factor = 1F; /* Множитель для подсройки расстоянний */
        float distance ;
        float vectorX;
        float vectorY;
        float cosX;
        float cosY;
        float buffForce;
        Acceleration acceleration = new Acceleration();
        for(Star star : stars)
        {
           vectorX=star.getCenterX()-planet.getCenterX();
           vectorY=star.getCenterY()-planet.getCenterY();
           distance= (float) (factor*Math.sqrt(Math.pow(vectorX,2)+Math.pow(vectorY,2))-planet.getR()-star.getR());
           cosX = vectorX/distance;
           cosY=  vectorY/distance;
           buffForce=G*planet.getMass()*star.getMass()/(distance*distance);
           acceleration.accelerationX+=buffForce*cosX/planet.getMass();
           acceleration.accelerationY+=buffForce*cosY/planet.getMass();
        }
        return acceleration;
    }
    public void updatePhysics(float delta)
    {
        if((delta+timeOfLatsUpdate)>=interval)
        {
            for(int i=0;i<((delta+timeOfLatsUpdate)/interval);i++)
            {
                for(Planet planet : planets)
                {
                    Acceleration acceleration= getAccelerationToStars(planet);
                    planet.setSpeedX(planet.getSpeedX()+(acceleration.accelerationX*delta));
                    planet.setSpeedY(planet.getSpeedY()+(acceleration.accelerationY*delta));
                    planet.setPosition(planet.getX()+(planet.getSpeedX()*delta),planet.getY()+(planet.getSpeedY()*delta));
                }
            }
            timeOfLatsUpdate=(delta+timeOfLatsUpdate)%interval;
        }
        else {
            timeOfLatsUpdate+=delta;
        }
    }
}
