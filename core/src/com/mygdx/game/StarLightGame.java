package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.LevelSelectScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.PauseScreen;
import com.mygdx.game.screens.ResultScreen;
import com.mygdx.game.tools.GameValues;

/**
 * Created by Leo on 25.06.2014.
 */
public class StarLightGame extends Game {

    public static enum GameState {GAME_SCREEN, MAIN_MENU_SCREEN, LEVEL_SELECT_SCREEN, PAUSE_SCREEN, RESULTS_SCREEN};

    private GameState gameState;
    private MainMenuScreen mainMenu;
    private GameScreen gameScreen;
    private LevelSelectScreen levelSelectScreen;
    private PauseScreen pauseScreen;
    private ResultScreen resultScreen;

    @Override
    public void create() {
        gameState = GameState.MAIN_MENU_SCREEN;
        setScreen(getMainMenu());
    }

    public MainMenuScreen getMainMenu() {
		if(mainMenu == null)
			setMainMenu(new MainMenuScreen(this));
        return mainMenu;
    }

    public void setMainMenu(MainMenuScreen mainMenu) {
        this.mainMenu = mainMenu;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public LevelSelectScreen getLevelSelectScreen() {
		if(levelSelectScreen == null)
			setLevelSelectScreen(new LevelSelectScreen(this, GameValues.LevelSelectCount, GameValues.LevelSelectTabels));
        return levelSelectScreen;
    }

    public void setLevelSelectScreen(LevelSelectScreen levelSelectScreen) {
        this.levelSelectScreen = levelSelectScreen;
    }

    public PauseScreen getPauseScreen() {
		if(pauseScreen == null)
			setPauseScreen(new PauseScreen(this));
        return pauseScreen;
    }

    public void setPauseScreen(PauseScreen pauseScreen) {
        this.pauseScreen = pauseScreen;
    }

    public ResultScreen getResultScreen() {
        return resultScreen;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setResultScreen(ResultScreen resultScreen) {
        this.resultScreen = resultScreen;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
