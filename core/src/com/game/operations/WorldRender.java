package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.game.Settings.Constants;
import com.game.object.Map;

import java.util.ArrayList;

/**
 * Klasa odpowiedzialna za rysowania świata
 * Created by Mazek27 on 01.04.2016.
 */
public class WorldRender implements Disposable {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    public WorldController getWorldController() {
        return worldController;
    }

    public WorldRender (WorldController worldController){
        this.worldController = worldController;
        init();
    }
    private void init(){
        batch = new SpriteBatch ();

        camera = new OrthographicCamera (Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0 + Constants.VIEWPORT_WIDTH / 2, 0 + Constants.VIEWPORT_HEIGHT / 2, 0);

        System.out.println(Gdx.app.getGraphics().getHeight());
        System.out.println(Gdx.app.getGraphics().getWidth());
        camera.update ();
    }

    public void render(){
        batch.setProjectionMatrix (camera.combined);
        batch.begin ();
        worldController.update (Gdx.graphics.getDeltaTime (),camera);
        batch.end ();
    }

    public void resize(int width, int height){
        camera.viewportHeight = (Constants.VIEWPORT_HEIGHT / height) * height;
        camera.viewportWidth = (Constants.VIEWPORT_WIDTH / width) * width;
//        System.out.println(height);
//        System.out.println(width);
        camera.update ();
    }

    public OrthographicCamera getCamera () {
        return camera;
    }

    /**
     * Releases all resources of this object.
     */
    @Override
    public void dispose () {

    }
}
