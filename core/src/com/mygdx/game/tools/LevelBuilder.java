package com.mygdx.game.tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.GameWorld;
import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.Star;
import com.mygdx.game.actors.User;

import java.util.Random;

/**
 * Created by Leo
 * on 11.07.2014.
 */

public class LevelBuilder {
	public void buildLevel(LevelInfo levelInfo, Stage stage) {
//		stage.addActor(levelInfo.ballista);
//		for (Star star : levelInfo.getStars()) {
//			stage.addActor(star);
//		}
		int levelArray[][] = levelInfo.getLevelArray();
		for (int i = 0; i < levelArray.length; i++) {
			for (int j = 0; j < levelArray[i].length; j++) {
				if(levelArray[i][j] == 1) {
					Block block = new Block(1);
					block.setPosition(i * GameValues.BlockDistance, j * GameValues.BlockDistance);
					block.setOrigin(block.getWidth() / 2, block.getHeight() / 2);
					block.setRotation(new Random().nextInt(360));
					levelInfo.addBlock(block);
					stage.addActor(block);
				}
			}
		}
	}
	public void buildLevel(LevelInfo levelInfo, GameWorld world) {
//		stage.addActor(levelInfo.ballista);
//		for (Star star : levelInfo.getStars()) {
//			stage.addActor(star);
//		}
		int levelArray[][] = levelInfo.getLevelArray();
		for (int i = 0; i < levelArray.length; i++) {
			for (int j = 0; j < levelArray[i].length; j++) {
				if(levelArray[i][j] == 1) {
					BodyDef groundBodyDef =new BodyDef();
					groundBodyDef.position.set(new Vector2(i * GameValues.BlockDistance, j * GameValues.BlockDistance));
					Body groundBody = world.getWorld().createBody(groundBodyDef);
					PolygonShape groundBox = new PolygonShape();
					groundBox.setAsBox(GameValues.BlockDistance * 0.5f, GameValues.BlockDistance * 0.5f);
					groundBody.createFixture(groundBox, 0.0f);
				} else if(levelArray[i][j] == 2) {
					BodyDef bodyDef = new BodyDef();
					bodyDef.type = BodyDef.BodyType.DynamicBody;
					bodyDef.position.set(new Vector2(i * GameValues.BlockDistance, j * GameValues.BlockDistance));
					Body body = world.getWorld().createBody(bodyDef);
					CircleShape dynamicCircle = new CircleShape();
					dynamicCircle.setRadius(GameValues.BlockDistance * 0.4f);
					FixtureDef fixtureDef = new FixtureDef();
					fixtureDef.shape = dynamicCircle;
					fixtureDef.density = 10.0f;
					fixtureDef.friction = 0.4f;
					fixtureDef.restitution = 0.7f;
					body.createFixture(fixtureDef);

					levelInfo.user = new User(1);
					levelInfo.user.setBodyDef(bodyDef);
					levelInfo.user.setBody(body);
					levelInfo.user.setDynamicCircle(dynamicCircle);
					levelInfo.user.setFixtureDef(fixtureDef);
//					world.getStage().addActor(levelInfo.user);
				}
			}
		}
	}
}
