package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.game.GUI.GUI;
import com.game.object.creature.Mob;
import com.game.operations.Movement;
import com.game.resources.Resources;


public class Wire2D extends Game {
	private String platform;
	private ObjectAll objectAll;
	private Resources resources;
	private SpriteBatch batch;
	private Movement movement;
	private GUI gui;

	public Wire2D(String platform) {
		this.platform = platform;
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		System.err.println(" width " + width + " height " + height);
	}

	//LOL
	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Tworzenie obiektow
	 */
	@Override
	public void create () {
		resources = new Resources ();
		objectAll = new ObjectAll(platform);
		batch = new SpriteBatch ();
		movement = new Movement (objectAll.mPlayer);
		gui = new GUI ();


		System.err.println("Width: " + Gdx.graphics.getWidth ());
		System.err.println("Height: " + Gdx.graphics.getHeight ());
	}

	@Override
	public void render () {
		movement.update(objectAll,(TiledMapTileLayer) objectAll.ObjectMap.get (objectAll.aMap).mMap.getLayers ().get (0));
		objectAll.render();

		batch.begin();
		objectAll.mPlayer.render (batch);
		for(Mob mob: objectAll.ObjectMap.get (objectAll.aMap).mMob){
			mob.render (batch);
		}
		gui.render (batch);

		batch.end();
	}
}
