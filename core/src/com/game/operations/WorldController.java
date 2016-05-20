package com.game.operations;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.game.object.Map;
import com.game.object.creature.Player;

import java.util.ArrayList;

/**
 * Zajmuje sie przetrzymywaniem światów
 * Created by Mazek27 on 01.04.2016.
 */
public class WorldController {
    private static final String TAG = WorldController.class.getName();
    private static String currentMapName;
    public static ArrayList<Map> objectMap;
    public int aMap;

    public WorldController () {
        init ();
    }

    private void init () {
        aMap = 0;

        objectMap = new ArrayList<Map> ();
        objectMap.add (new Map("shop_place"));
    }
    public void update (float deltaTime, OrthographicCamera camera, Player player) {
        objectMap.get (aMap).render (camera, player);
    }

    public void changeMap(String index, String name, Player player){
        for(int i = 0 ; i < objectMap.size (); i++){
            if(objectMap.get (i).mName == name){
                this.aMap = i;
                objectMap.get(i).getStage().addActor(player);
                break;
            }

            if(i == objectMap.size () -1){
                objectMap.add (new Map(name));
                this.aMap = objectMap.size () - 1;
            }

        }

        TiledMapTileLayer TMTL = (TiledMapTileLayer) objectMap.get (aMap).mMap.getLayers ().get (0);

        for(int i = 0; i < 40; i++){
            for(int j = 0; j < 20; j++){
                if(Testy.isSpawn (TMTL,i,j)){
                    if(Testy.index (TMTL,i,j).equals (index)){
                        player.setPosition(i * 32, j * 32);
                        break;
                    }
                }
            }
        }
    }
}

