package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.StarLightGame;
import com.mygdx.game.tools.Setting;

public abstract class AbstractScreen implements Screen {

    public static final int CAMERA_WIDTH = 1000, CAMERA_HEIGHT = 1000;


    protected final StarLightGame game;
    protected final Stage stage;
    protected final Viewport viewport;
    protected final OrthographicCamera camera;
    protected final SpriteBatch batch;
    protected Table setting;

    private CheckBox chBxMusic;
    private TextButton btnPause;
    private float defPosX, defPosY;


    public AbstractScreen(final StarLightGame game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        viewport = new ScreenViewport(camera);
        this.stage = new Stage(viewport);
        defPosX = camera.position.x;
        defPosY = camera.position.y;
        Skin skin = new Skin(Gdx.files.internal("Menu/uiskin.json"));
        setting = new Table();
        setting.setFillParent(true);
        setting.center();
        chBxMusic = new CheckBox("Sound", skin);
        chBxMusic.setChecked(Setting.getSound());
        chBxMusic.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Setting.setSound(chBxMusic.isChecked());
            }
        });
        setting.add(chBxMusic).expand().bottom().left();
        setting.setName("SETTING");
        setting.setTransform(true);
        stage.addActor(setting);
    }

    public void addBtnPause() {
        Skin skin = new Skin(Gdx.files.internal("Menu/uiskin.json"));
        btnPause = new TextButton("Pause", skin);
        setting.add(btnPause).expand().top().right();
        btnPause.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Pressed btnPlay");
                game.setGameState(StarLightGame.GameState.PAUSE_SCREEN);
                game.setScreen(game.getPauseScreen());
            }
        });
        setting.row();
    }

    @Override
    public void show() {
        Gdx.app.log("AbstractScreen", "show()");

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("AbstractScreen", "resize()");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //System.out.println("NEW CAM ZOOM:"+Float.toString(camera.zoom));
        for (int i = 0; i < stage.getActors().size; i++) {
            if (stage.getActors().get(i).getName() == "SETTING") {
                stage.getActors().get(i).setPosition((camera.position.x - defPosX) - defPosX * (camera.zoom - 1), (camera.position.y - defPosY) - defPosY * (camera.zoom - 1));
                stage.getActors().get(i).setScale(camera.zoom);
            }
        }
        stage.act(delta);
        batch.setProjectionMatrix(camera.view);
        batch.begin();
        stage.draw();
        batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            System.err.println("menu");
        }
    }

    @Override
    public void hide() {
        Gdx.app.log("AbstractScreen", "hide()");

    }

    @Override
    public void pause() {
        Gdx.app.log("AbstractScreen", "pause()");

    }

    @Override
    public void resume() {
        Gdx.app.log("AbstractScreen", "resume()");

    }

    @Override
    public void dispose() {
        Gdx.app.log("AbstractScreen", "dispose()");
        batch.dispose();
        stage.dispose();
    }
}
