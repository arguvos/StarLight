package com.mygdx.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Leo
 * on 11.07.2014.
 */
public class StarGestureListener implements GestureDetector.GestureListener {

	private float initialScale = 1.0f;
	private OrthographicCamera camera;

	public StarGestureListener(OrthographicCamera camera) {
		this.camera = camera;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		initialScale = ValuesContainer.zoom;
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		camera.translate(-deltaX * camera.zoom, deltaY * camera.zoom);
		camera.update();
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		float ratio = initialDistance / distance;
		ValuesContainer.zoom = MathUtils.clamp(initialScale * ratio, 0.05f, 2.0f);
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}
