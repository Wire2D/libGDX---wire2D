package com.game.Scene;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.game.Drop;
import com.game.GUI.GUI;
import com.game.androidNavigation.Nav;
import com.game.object.creature.Player;
import com.game.operations.Attack;
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
    private Attack attackController;
    private Resources resources;
    private GUI gui;
    private Nav androidNav;
    private FPSLogger fps;

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
        attackController = new Attack(player);
        androidNav = new Nav();
        gui = new GUI();
        fps = new FPSLogger();


        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            Gdx.app.getGraphics().setWindowedMode(100, 100);
            Gdx.app.getGraphics().setWindowedMode(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
            //Gdx.app.getGraphics().setFullscreenMode(Gdx.graphics.getDisplayMode());
        } else {
            Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        }



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
        fps.log();
        Gdx.gl.glClearColor (0,0,0,0);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

        //Update movement
        int aMap = worldRenderer.getWorldController().aMap;
        movement.update(worldController, (TiledMapTileLayer) worldRenderer.getWorldController().ObjectMap.get(aMap).mMap.getLayers().get(0));
        attackController.update(null);
        //Render game screen
        worldRenderer.render ();
        //Render player
        player.render(game.batch);
        //androidNav.render();
        GUI.render(game.batch,player.getHP(), player.getmHP(), attackController.getcSkill());
    }

    /**
     * Zmiana wielkosci okna
     */
    @Override
    public void resize (int width, int height) {
        worldRenderer.resize (width,height);
    }

    /**
     * Co dzieje sie po zapałzowaniu gry
     */
    @Override
    public void pause () {
        paused = true;
    }

    /**
     * Co dzieje sie po wznowieniu gry
     */
    @Override
    public void resume () {
        paused = false;
    }

    /**
     * Co dzieje sie gdy schowam gre do paska
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
