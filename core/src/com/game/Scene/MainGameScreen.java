package com.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.game.Drop;
import com.game.ObjectAll;
import com.game.androidNavigation.Nav;
import com.game.object.creature.Player;
import com.game.operations.Movement;
import com.game.operations.WorldController;
import com.game.operations.WorldRender;
import com.game.resources.Resources;

/**
 * Created by Mazek27 on 01.04.2016.
 */
public class MainGameScreen implements Screen {
    private static final String TAG = MainGameScreen.class.getName();
    private Drop game;
    private WorldController worldController;
    private WorldRender worldRenderer;
    private Movement movement;
    private Player player;
    private ObjectAll objectAll;
    private Resources resources;
    private Nav androidNav;

    private boolean paused;

    public MainGameScreen (final Drop game) {
        this.game = game;
    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show () {
        worldController = new WorldController ();
        worldRenderer = new WorldRender (worldController);
        resources = new Resources();
        player = new Player("adas");
        movement = new Movement(player);
        objectAll = new ObjectAll();
        androidNav = new Nav();


        paused = false;
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render (float delta) {
        worldController.update (delta, worldRenderer.getCamera ());
        Gdx.gl.glClearColor (0,0,0,0);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

        //Update movement
        int aMap = worldRenderer.getWorldController().aMap;
        movement.update(worldController, (TiledMapTileLayer) worldRenderer.getWorldController().ObjectMap.get(aMap).mMap.getLayers().get(0));                      //objectAll.ObjectMap.get (objectAll.aMap).mMap.getLayers ().get (0));
        //Render game screen
        worldRenderer.render ();
        //Render player
        player.render(game.batch);
        androidNav.render();
    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize (int width, int height) {
        worldRenderer.resize (width,height);
    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause () {
        paused = true;
    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume () {
        paused = false;
    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide () {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose () {
        worldRenderer.dispose ();
    }
}