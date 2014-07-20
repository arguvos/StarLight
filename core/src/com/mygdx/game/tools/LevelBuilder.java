package com.mygdx.game.tools;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.Star;

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
}
