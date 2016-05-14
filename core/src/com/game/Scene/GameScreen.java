package com.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.game.Drop;
import com.game.GUI.GUI;
import com.game.ObjectAll;
import com.game.object.creature.Mob;
import com.game.operations.Movement;
import com.game.resources.Resources;

/**
 * Created by Mazek27 on 28.03.2016.
 */
public class GameScreen implements Screen {

    final Drop game;

    OrthographicCamera camera;

    private ObjectAll objectAll;
    private Resources resources;
    private SpriteBatch batch;
    private Movement movement;
    private GUI gui;

    public GameScreen (final Drop game) {
        this.game = game;

        camera = new OrthographicCamera ();
        camera.setToOrtho(false, Gdx.graphics.getWidth () / 2, Gdx.graphics.getHeight () / 2);

        resources = new Resources ();
        //objectAll = new ObjectAll(camera);
        batch = new SpriteBatch ();
        movement = new Movement (objectAll.mPlayer);
        gui = new GUI ();
    }

    @Override
    public void show () {

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor (0, 0, 0, 0);
        Gdx.gl.glClear (GL20.GL_COLOR_BUFFER_BIT);
        //movement.update(objectAll,(TiledMapTileLayer) objectAll.ObjectMap.get (objectAll.aMap).mMap.getLayers ().get (0));
        //objectAll.render();

        camera.update ();
        game.batch.setProjectionMatrix (camera.combined);

        game.batch.begin();
        objectAll.mPlayer.render (game.batch);
        for(Mob mob: objectAll.ObjectMap.get (objectAll.aMap).mMob){
            mob.render (game.batch);
        }
        //gui.render (game.batch);
        game.batch.end();

        if (Gdx.input.isKeyPressed (Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenuScreen(game));
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
