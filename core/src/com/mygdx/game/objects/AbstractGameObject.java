package com.mygdx.game.objects;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.tools.GameValues;

/**
 * Created by God on 25.07.2014.
 */
public abstract class AbstractGameObject {
	protected Body body;
    protected Sprite sprite;
	protected TextureRegion textureRegion;
	protected float width;
	protected float height;

    public AbstractGameObject(Body body) {
        this.body = body;
    }

    public void render(SpriteBatch sb) {
		sb.draw(textureRegion,
				(body.getPosition().x * GameValues.PPM - width / 2),
				(body.getPosition().y * GameValues.PPM - height / 2),
				width * .5f, height * .5f,
				width, height,
				1, 1, body.getAngle() * MathUtils.radDeg, false);

	}

    public Body getBody() { return body; }
    public Vector2 getPosition() { return body.getPosition(); }
    public float getWidth() { return width; }
    public float getHeight() { return height; }
}
