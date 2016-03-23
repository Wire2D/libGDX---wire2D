package com.game.object;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Map {
    public TiledMap mMap;
    public String mName;
    TiledMapRenderer tiledMapRenderer;
    int[] backgroudLayers;

    /**
     *
     * @param nazwa = nazwa mapy
     */
    public Map (String nazwa) {

        this.mName = nazwa;
        try {
            mMap = new TmxMapLoader ().load ("res/map/" + nazwa + ".tmx");
        } catch (Exception e) {
            mMap = new TmxMapLoader ().load ("core/res/map/" + nazwa + ".tmx");
        }
        tiledMapRenderer = new OrthogonalTiledMapRenderer (mMap);

        backgroudLayers = new int[mMap.getLayers ().getCount ()];
        for(int i =0; i < mMap.getLayers ().getCount (); i++){
            this.backgroudLayers[i] = i;
        }

    }

    /**
     * Renderuje obraz mapy
     * @param camera = widok
     */
    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView (camera);
        tiledMapRenderer.render (backgroudLayers);
    }
}