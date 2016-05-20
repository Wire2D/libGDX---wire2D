package com.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.game.Drop;
import com.game.Settings.Constants;

/**
 * Created by Mazek27 on 28.03.2016.
 */
public class MainMenuScreen implements Screen {

    final Drop game;
    OrthographicCamera camera;

    public MainMenuScreen(final Drop gam){
        game = gam;

        camera = new OrthographicCamera ();
        camera.setToOrtho(false, Gdx.graphics.getWidth () / 2, Gdx.graphics.getHeight () / 2);
    }

    @Override
    public void show () {

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor (0, 0, 0.2f, 1);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);

        camera.update ();
        game.batch.setProjectionMatrix (camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed (Keys.ESCAPE)) {
            game.setScreen(Constants.gameMainScreen);
            dispose();
        }
    }

    @Override
    public void resize (int width, int height) {

    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }
}
