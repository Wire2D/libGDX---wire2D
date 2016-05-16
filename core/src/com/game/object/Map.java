package com.game.object;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.game.object.creature.Mob;
import com.game.operations.Testy;

import java.util.ArrayList;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Map {
    public TiledMap mMap;
    public String mName;
    TiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer tiledMapTileLayer;
    int[] backgroudLayers;
    public ArrayList<Mob> mMob;

    /**
     *
     * @param nazwa = nazwa mapy
     */
    public Map (String nazwa) {

        this.mName = nazwa;

            mMap = new TmxMapLoader ().load ("res/map/" + nazwa + ".tmx");

        tiledMapRenderer = new OrthogonalTiledMapRenderer (mMap);

        backgroudLayers = new int[mMap.getLayers ().getCount ()];
        for(int i =0; i < mMap.getLayers ().getCount (); i++){
            this.backgroudLayers[i] = i;
        }

        mMob = new ArrayList<Mob> ();

        TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer) mMap.getLayers ().get (0);

        for(int i = 0; i < 40; i++){
            for(int j = 0; j < 20; j++){
                if(Testy.isMob (tiledMapTileLayer,i,j)){
                    System.out.println("mobek " + Testy.name(tiledMapTileLayer,i,j) + " level: " + Integer.parseInt (Testy.getLevel (tiledMapTileLayer,i,j)));
                    mMob.add (new Mob(Testy.name(tiledMapTileLayer,i,j),i,j,Integer.parseInt (Testy.getLevel (tiledMapTileLayer,i,j))));
                }
            }
        }

    }

    /**
     * Renderuje obraz mapy
     * @param camera = widok
     */
    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView (camera);
        tiledMapRenderer.render (backgroudLayers);
        renderMobs();
    }

    //begin scorpion43
    //funkcja do renderowania mobow
    public void renderMobs() {
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        for (Mob mob : mMob) {
            mob.render(batch, tiledMapTileLayer);
        }
        batch.end();
    }
    //end scorpion43
}