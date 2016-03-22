package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.object.creature.Player;

/**
 * Created by Mazek27 on 21.03.2016.
 */
public class ObjectAll {
    TiledMap map;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    Viewport viewport;
    Player mPlayer;

    public ObjectAll(String platform){
        mPlayer = new Player ("player");

        float w = Gdx.app.getGraphics().getWidth();
        float h = Gdx.app.getGraphics().getHeight();


        try{
            map = new TmxMapLoader().load("res/map/shop_place.tmx");
        } catch (Exception e){
            map = new TmxMapLoader().load("core/res/map/shop_place.tmx");
        }

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        if(platform.equals ("desktop")){
            viewport = new FillViewport (w,h,camera);
            viewport.apply();
            camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        } else {
            camera.setToOrtho(false,w,h);
        }
        camera.update();
    }

    public void render(){
        camera.update();
        tiledMapRenderer.setView(camera);
        int[] backgroudLayers = { 0, 1, 2, 3};
        tiledMapRenderer.render(backgroudLayers);
    }
}
