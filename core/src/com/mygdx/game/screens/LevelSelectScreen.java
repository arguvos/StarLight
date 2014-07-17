package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.StarLightGame;
import com.mygdx.game.input.StarGestureListener;
import com.mygdx.game.input.StarInputProcessor;

import sun.font.TextLabel;

/**
 * Created by Jendoss on 13.07.2014.
 */
public class LevelSelectScreen extends AbstractScreen {


    private InputMultiplexer inputMultiplexer;
    private StarGestureListener starGestureListener;
    private StarInputProcessor starInputProcessor;


    private TextureAtlas atlas;
    private int levelsAmount;
    private int tablesAmount;
    private int h;

    public static final int TABLE_HEIGHT = CAMERA_HEIGHT / 5;
    public static final int TABLE_WIDTH = CAMERA_WIDTH / 2;


    public LevelSelectScreen(StarLightGame game, int levelsAmount, int tablesAmount) {
        super(game);
        this.levelsAmount = levelsAmount;
        this.tablesAmount = tablesAmount;
    }

    public int getLevelsAmount() {
        return levelsAmount;
    }

    public void setLevelsAmount(int levelsAmount) {
        this.levelsAmount = levelsAmount;
    }

    public int getTablesAmount() {
        return tablesAmount;
    }

    public void setTablesAmount(int tablesAmount) {
        this.tablesAmount = tablesAmount;
    }

    @Override
    public void show() {
        super.show();
        initaliseInputProcessors();

        //Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("Menu/uiskin.json"));

        Table table = new Table();
        table.setFillParent(true);
        table.setHeight(TABLE_HEIGHT);
        table.setWidth(TABLE_WIDTH);
        table.center();

        TextButton levels[] = new TextButton[levelsAmount];
        int currentTableLevelsNumber =  (int) Math.ceil(levelsAmount / tablesAmount);
        h = (int)Math.floor(Math.sqrt(TABLE_HEIGHT * TABLE_WIDTH / currentTableLevelsNumber));
        double H = Math.ceil(TABLE_HEIGHT/h) + ((TABLE_HEIGHT % h == 0) ? 0 : 1);
        double W = currentTableLevelsNumber/H;
        int currentLevel = 0;
        System.out.println(H);
        System.out.println(h);
        for (int i = 0; i < H ; i++) {
            for (int j = 0; j < W ; j++) {

                if(currentLevel + 1 >= currentTableLevelsNumber) break;
                currentLevel = (int) Math.ceil(i * W) + j;

                levels[currentLevel] = new TextButton(String.valueOf(currentLevel + 1), skin);
                levels[currentLevel].addListener(new ChangeListener() {
                    public void changed(ChangeEvent event, Actor actor) {
                       // game.setScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                        System.err.println("level=" + Integer.valueOf(((TextButton) actor).getText().toString()));
                        game.setGameScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                        game.setGameState(StarLightGame.GameState.GAME_SCREEN);
                        game.setScreen(game.getGameScreen());
                    }
                });
                table.add(levels[currentLevel]).fill().pad(10).width(h).height(h);
            }
            table.row();


        }


        for (currentLevel++; currentLevel < currentTableLevelsNumber; currentLevel++) {
            levels[currentLevel] = new TextButton(String.valueOf(currentLevel + 1), skin);
            levels[currentLevel].addListener(new ChangeListener() {
                public void changed(ChangeEvent event, Actor actor) {
                   // game.setScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                    System.err.println("level=" + Integer.valueOf(((TextButton) actor).getText().toString()));
                    game.setGameScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                    game.setGameState(StarLightGame.GameState.GAME_SCREEN);
                    game.setScreen(game.getGameScreen());
                }
            });
            table.add(levels[currentLevel]).fill().pad(10).width(h).height(h);

        }

        Table bottomTable = new Table();

        bottomTable.setFillParent(true);

        bottomTable.add(new Label("1", skin)).pad(5);
        bottomTable.add(new Label("2", skin)).pad(5);
        bottomTable.add(new Label("3", skin)).pad(5);
        bottomTable.setWidth(70);
        bottomTable.setHeight(10);
        bottomTable.center().bottom();


        table.debug();
        bottomTable.debug();

        stage.addActor(table);
        stage.addActor(bottomTable);




    }

    public void initaliseInputProcessors() {
        inputMultiplexer = new InputMultiplexer();

        Gdx.input.setInputProcessor(inputMultiplexer);
        starGestureListener = new StarGestureListener(this.camera);
        starInputProcessor = new StarInputProcessor(this.camera);
        inputMultiplexer.addProcessor(new GestureDetector(starGestureListener));
        inputMultiplexer.addProcessor(starInputProcessor);
        inputMultiplexer.addProcessor(stage);
    }




    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //Table.drawDebug(stage);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
