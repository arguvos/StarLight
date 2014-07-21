package com.mygdx.game.tools;

import com.mygdx.game.actors.Ballista;
import com.mygdx.game.actors.Block;
import com.mygdx.game.actors.GZone;
import com.mygdx.game.actors.Planet;
import com.mygdx.game.actors.Star;
import com.mygdx.game.actors.User;

import java.util.ArrayList;

/**
 * Created by Leo on 28.06.2014.
 */
public class LevelInfo {
    ArrayList<Planet> planets;
    ArrayList<Star> stars;
    ArrayList<GZone> zones;
    Ballista ballista;
    String description;
    int levelNumber;

    int cameraX;
    int cameraY;

	private int[][] levelArray;
	private ArrayList<Block> blocks;
	public User user;

    public LevelInfo() {
//        planets = new ArrayList<Planet>();
//        stars = new ArrayList<Star>();
//        zones = new ArrayList<GZone>();
//        ballista = new Ballista();
		blocks = new ArrayList<Block>();
    }

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public void addBlock(Block block) {
		this.blocks.add(block);
	}

	public void setLevelArray(int[][] levelArray) { this.levelArray = levelArray; }

	public int[][] getLevelArray() { return levelArray; }

    public int getCameraX() {
        return cameraX;
    }

    public void setCameraX(int cameraX) {
        this.cameraX = cameraX;
    }

    public int getCameraY() {
        return cameraY;
    }

    public void setCameraY(int cameraY) {
        this.cameraY = cameraY;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public void addStar(Star star) {
        this.stars.add(star);
    }

    public Ballista getBallista() {
        return ballista;
    }

    public void setBallista(Ballista ballista) {
        this.ballista = ballista;
    }

    public ArrayList<GZone> getZones() {
        return zones;
    }

    public void setZones(ArrayList<GZone> zones) {
        this.zones = zones;
    }

    public void addZone(GZone zone) {
        this.zones.add(zone);
    }

    public void setLevelNumber(int levelNumber) {this.levelNumber = levelNumber;}

    public int  getLevelNumber() { return levelNumber;}
}
