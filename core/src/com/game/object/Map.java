package com.game.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.object.creature.Mob;
import com.game.object.creature.Player;
import com.game.operations.Testy;

import java.util.ArrayList;

/**
 * Klasa zawiera podstawowe informacje na temat mapy
 * Created by Mazek27 on 22.03.2016.
 */
public class Map extends Stage {
    //public int index;
    public TiledMap mMap;
    public String mName;
    private TiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer collisionLayer;
    private int[] backgroudLayers;
    private ArrayList<Mob> mMob;

    public Map (String nazwa) {
        this.mName = nazwa;

            mMap = new TmxMapLoader ().load ("res/map/" + nazwa + ".tmx");

        tiledMapRenderer = new OrthogonalTiledMapRenderer (mMap);

        backgroudLayers = new int[mMap.getLayers ().getCount ()];
        for(int i =0; i < mMap.getLayers ().getCount (); i++){
            this.backgroudLayers[i] = i;
        }

        mMob = new ArrayList<Mob> ();

        TiledMapTileLayer TMTL = (TiledMapTileLayer) mMap.getLayers ().get (0);

        for(int i = 0; i < 40; i++){
            for(int j = 0; j < 20; j++){
                if(Testy.isMob (TMTL,i,j)){
                    System.out.println("mobek " + Testy.name(TMTL,i,j) + " level: " + Integer.parseInt (Testy.getLevel (TMTL,i,j)));
                    Mob mob = new Mob(Testy.name(TMTL, i, j), i, j, Integer.parseInt(Testy.getLevel(TMTL, i, j)));
                    mMob.add (mob);
                    addActor(mob);
                }
            }
        }
        collisionLayer = (TiledMapTileLayer) mMap.getLayers().get(0);
    }

    /**
     * Renderuje obraz mapy
     * @param camera = widok
     */
    public void render(SpriteBatch batch, OrthographicCamera camera, Player player){
        tiledMapRenderer.setView (camera);
        tiledMapRenderer.render (backgroudLayers);
        renderMobs(batch, collisionLayer, player);
    }

    /**
     * funkcja do renderowania mobow
     * @param collisionLayer Warstwa blokowana
     * parampampam
     */
    private void renderMobs(SpriteBatch batch, TiledMapTileLayer collisionLayer, Player player) {
        batch.begin();
        for (Mob mob : mMob) {
            mob.render(batch, collisionLayer, player);
        }
        batch.end();
    }
}