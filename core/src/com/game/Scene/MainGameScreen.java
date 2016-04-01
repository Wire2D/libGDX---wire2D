package com.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.game.Drop;
import com.game.operations.WorldController;
import com.game.operations.WorldRender;

/**
 * Created by Mazek27 on 01.04.2016.
 */
public class MainGameScreen implements Screen {
    private static final String TAG = MainGameScreen.class.getName();
    private Drop game;
    private WorldController worldController;
    private WorldRender worldRenderer;
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

        //Render game screen
        worldRenderer.render ();
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
