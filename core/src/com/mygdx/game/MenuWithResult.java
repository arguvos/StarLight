package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuWithResult implements Screen {
    final Game game;
    OrthographicCamera cam;
    Texture background, btnExitToMenu, btnRestart, textBestScore, textYourScore, title, numbers;
    TextureRegion number;

    private int width = 800;
    private int height = 480;
    private int score, bestScore;

    public MenuWithResult(final Game game, int score, int bestScore) {
        this.game = game;
        this.score=score;
        this.bestScore=bestScore;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, width, height);
        background = new Texture("MenuResult/backgroundMenuResult.png");
        btnExitToMenu = new Texture("MenuResult/btnExitToMenu.png");
        btnRestart = new Texture("MenuResult/btnRestart.png");
        textBestScore = new Texture("MenuResult/textBestScore.png");
        textYourScore = new Texture("MenuResult/textYourScore.png");
        title = new Texture("MenuResult/title.png");
        numbers = new Texture("MenuResult/textNumbers.png");
    }

    @Override
    public void render(float delta) {
        int offsetX=0, offsetY=0, offsetElementY=0;

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        game.batch.setProjectionMatrix(cam.combined);

        offsetElementY=title.getHeight();
        offsetX=width/2-title.getWidth()/2;
        offsetY=(height-offsetElementY*8)/2;

        game.batch.begin();
            game.batch.draw(background, 0, 0, width, width);
            String strScore=Integer.toString(score);
            for (int i=0; i<strScore.length(); i++){
                int n=Integer.parseInt(Character.toString(strScore.charAt(i)));
                number=new TextureRegion(numbers, n*25, 0, 25, 45);
                game.batch.draw(number, offsetX + i * 25, offsetY + offsetElementY * 5);
            }
            String strBestScore=Integer.toString(bestScore);
            for (int i=0; i<strBestScore.length(); i++){
                int n=Integer.parseInt(Character.toString(strBestScore.charAt(i)));
                number=new TextureRegion(numbers, n*25, 0, 25, 45);
                game.batch.draw(number, offsetX + i * 25, offsetY + offsetElementY * 3);
            }
            game.batch.draw(title, offsetX, offsetY+offsetElementY*8);
            game.batch.draw(textYourScore, offsetX, offsetY+offsetElementY*6);
            game.batch.draw(textBestScore, offsetX, offsetY+offsetElementY*4);
            game.batch.draw(btnRestart, offsetX, offsetY+offsetElementY*2);
            game.batch.draw(btnExitToMenu, offsetX, offsetY);
            game.font.draw(game.batch, Integer.toString(width), 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, width, height);
        cam.update();
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
