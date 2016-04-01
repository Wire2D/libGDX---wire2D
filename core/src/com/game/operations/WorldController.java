package com.game.operations;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Mazek27 on 01.04.2016.
 */
public class WorldController {
    private static final String TAG = WorldController.class.getName();
    private static String currentMapName;
    public static TiledMapRenderer tiledMapRenderer;
    public static TiledMap tiledMap;

    public WorldController () {
        init ();
    }

    private void init () {
        tiledMap = new TmxMapLoader ().load ("res/map/shop_place.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer (tiledMap);
    }
    public void update (float deltaTime, OrthographicCamera camera) {
        tiledMapRenderer.setView (camera);
        tiledMapRenderer.render ();
    }
}

