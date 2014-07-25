package com.mygdx.game.actors;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

/**
 * Created by God on 25.07.2014.
 */
public abstract class AbstractGameObject {
    private Body body;
    private Sprite sprite;
    private float width;
    private float height;

    public AbstractGameObject(Body body) {
        this.body = body;
        body.setUserData(this); /* надеюсь это законно */
    }

    public void setSprite(Sprite sprite) {
        this.sprite=sprite;

    }

    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(sprite, (body.getPosition().x * GameValues.PixelsInMeter - width / 2), (int) (body.getPosition().y * GameValues.PixelsInMeter - height / 2));
        sb.end();
    }

    public Body getBody() { return body; }
    public Vector2 getPosition() { return body.getPosition(); }
    public float getWidth() { return width; }
    public float getHeight() { return height; }

}
