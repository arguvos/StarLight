package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.StarLightGame;
import com.mygdx.game.input.StarInputProcessor;

/**
 * Created by Jendoss on 13.07.2014.
 */
public class LevelSelectScreen extends AbstractScreen implements GestureDetector.GestureListener{


    private InputMultiplexer inputMultiplexer;
    private StarInputProcessor starInputProcessor;
    private Table tables[];
    private Table bottomTable;
    private Label bottomLables[];
    private TextButton levels[];
    private Skin skin;

    private int levelsAmount;
    private int tablesAmount;
    private int h; //level button height and width
    private int currentTableLevelsNumber;
    private int currentSection = 1;
    private int speed = 300;
    private int stopOffset = 2;
    private int levelButtonDistance = 10;
    private int bottomTableItemDistance = 5;

    private float amountX = 0;
    private float tableDistance = 150;
    private float changeOffset = 150;
    private float overscrollDistance = 100;

    private boolean isPan = false;
    private boolean isTapble = true;
    private boolean isRecoverForcibly = false;
    private boolean isTableChange = false;


    private static final float TABLE_HEIGHT = CAMERA_HEIGHT / 5;
    private static final float TABLE_WIDTH = CAMERA_WIDTH / 1;
    private static final float BOTTOM_TABLE_WIDTH = 75;
    private static final float BOTTOM_TABLE_HEIGHT = 10;
    private final float TABLE_DISTANCE = TABLE_WIDTH + tableDistance;


    public LevelSelectScreen(StarLightGame game, int levelsAmount, int tablesAmount) {
        super(game);
        this.levelsAmount = levelsAmount;
        this.tablesAmount = tablesAmount;
        this.tables = new Table[tablesAmount];
        this.levels = new TextButton[levelsAmount];
        this.skin = new Skin(Gdx.files.internal("Menu/uiskin.json"));

        for (int i = 0; i < tablesAmount; i++) {
            tables[i] = new Table();
            tables[i].setFillParent(true);
            tables[i].setHeight(TABLE_HEIGHT);
            tables[i].setWidth(TABLE_WIDTH);
            tables[i].center();
            tables[i].setX(i*TABLE_DISTANCE);
        }

        currentTableLevelsNumber =  (int) Math.ceil(levelsAmount / tablesAmount);
        h = (int)Math.floor(Math.sqrt(TABLE_HEIGHT * TABLE_WIDTH / currentTableLevelsNumber));
        double H = Math.ceil(TABLE_HEIGHT/h) + ((TABLE_HEIGHT % h == 0) ? 0 : 1);
        double W = currentTableLevelsNumber/H;
        int currentLevel = 0;

        for (int i = 0; i < tablesAmount; i++) {
            currentLevel = fillTable(H,W,currentLevel,currentTableLevelsNumber,tables[i]);
        }


        bottomTable = new Table();
        bottomLables = new Label[tablesAmount];
        bottomTable.setFillParent(true);
        for (int i = 0; i < tablesAmount; i++) {
            if(i == 0) bottomLables[i] = new Label("o", skin);
            else bottomLables[i] = new Label(".", skin);
            bottomTable.add(bottomLables[i]).pad(bottomTableItemDistance);
        }
        bottomTable.setWidth(BOTTOM_TABLE_WIDTH);
        bottomTable.setHeight(BOTTOM_TABLE_HEIGHT);
        bottomTable.center().bottom();


        for (int i = 0; i < tablesAmount; i++) {
            stage.addActor(tables[i]);
        }
        stage.addActor(bottomTable);
    }


    private int fillTable(double H, double W, int currentLevel, int currentTableLevelsNumber, Table table)
    {
        int prefixLevel = currentLevel;
        currentLevel = 0;

        for (int i = 0; i < H ; i++) {
            for (int j = 0; j < W ; j++) {

                if(currentLevel + 1 >= currentTableLevelsNumber) break;
                currentLevel = (int) Math.ceil(i * W) + j;

                levels[currentLevel] = new TextButton(String.valueOf(currentLevel + 1 + prefixLevel), skin);
                levels[currentLevel].addListener(new ChangeListener() {
                    public void changed(ChangeEvent event, Actor actor) {
                        if(isTapble) {
                            System.err.println("level=" + Integer.valueOf(((TextButton) actor).getText().toString()));
                            game.setGameScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                            game.setGameState(StarLightGame.GameState.GAME_SCREEN);
                            game.setScreen(game.getGameScreen());
                        }
                    }
                });
                table.add(levels[currentLevel]).fill().pad(levelButtonDistance).width(h).height(h);
            }
            table.row();
        }

        for (currentLevel++; currentLevel < currentTableLevelsNumber; currentLevel++) {
            levels[currentLevel] = new TextButton(String.valueOf(currentLevel + 1), skin);
            levels[currentLevel].addListener(new ChangeListener() {
                public void changed(ChangeEvent event, Actor actor) {
                    if(isTapble) {
                        System.err.println("level=" + Integer.valueOf(((TextButton) actor).getText().toString()));
                        game.setGameScreen(new GameScreen(game, Integer.valueOf(((TextButton) actor).getText().toString())));
                        game.setGameState(StarLightGame.GameState.GAME_SCREEN);
                        game.setScreen(game.getGameScreen());
                    }

            }});

                    table.add(levels[currentLevel]).fill().pad(levelButtonDistance).width(h).height(h);
        }

        return currentLevel+prefixLevel;
    }



    @Override
    public void show() {
        super.show();
        initaliseInputProcessors();

    }

    public void initaliseInputProcessors() {
        inputMultiplexer = new InputMultiplexer();

        Gdx.input.setInputProcessor(inputMultiplexer);
        starInputProcessor = new StarInputProcessor();
        inputMultiplexer.addProcessor(new GestureDetector(this));
        inputMultiplexer.addProcessor(starInputProcessor);
        inputMultiplexer.addProcessor(stage);
    }


    private void setCurrentSection(int section)
    {
        if(section < 1) section = 1;
        if(section > tablesAmount) section = tablesAmount;
        bottomLables[currentSection - 1].setText(".");
        currentSection = section;
        bottomLables[currentSection - 1].setText("o");
    }

    private void move(float delta)
    {

        isTapble = false;

        if ( amountX < -overscrollDistance ) {
            amountX = -overscrollDistance;
        }
        if ( amountX > ((tablesAmount - 1)* TABLE_DISTANCE + overscrollDistance)){
            amountX = (tablesAmount - 1)* TABLE_DISTANCE + overscrollDistance;
        }

        if(amountX > changeOffset + (currentSection - 1)*TABLE_DISTANCE) {
            setCurrentSection(currentSection + 1);
            amountX = -changeOffset + (currentSection - 1)*TABLE_DISTANCE + 50;
            isRecoverForcibly = true;
            isTableChange = true;
        }
        else if(amountX  < -changeOffset + (currentSection - 1)*TABLE_DISTANCE) {
            setCurrentSection(currentSection - 1);
            amountX = changeOffset + (currentSection - 1)*TABLE_DISTANCE - 50;
            isRecoverForcibly = true;
            isTableChange = true;
        }





            if(!isPan || isRecoverForcibly) {
                isTapble = true;
                isRecoverForcibly = false;
                if (amountX > stopOffset + (currentSection - 1) * TABLE_DISTANCE) {
                    amountX -= speed * delta;
                    isRecoverForcibly = true;
                }
                if (amountX < -stopOffset + (currentSection - 1) * TABLE_DISTANCE) {
                    amountX += speed * delta;
                    isRecoverForcibly = true;
                }

            }




    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {

        move(delta);
        for (int i = 0; i < tablesAmount; i++) {
            tables[i].setX(i*TABLE_DISTANCE - (int)amountX);
        }
        super.render(delta);
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

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {return false;}



    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {return false;}

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        isPan = true;
        if(!isTableChange) amountX -= deltaX;
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        isPan = false;
        isTableChange = false;
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {return false; }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
