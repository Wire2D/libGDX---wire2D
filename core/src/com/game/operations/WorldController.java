package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.game.GUI.UI;
import com.game.object.Map;
import com.game.object.creature.Player;

import java.util.ArrayList;

/**
 * Zajmuje sie przetrzymywaniem światów
 * Created by Mazek27 on 01.04.2016.
 */
public class WorldController {
    private static final String TAG = WorldController.class.getName();
    public static ArrayList<Map> objectMap;
    public int aMap;

    public WorldController () {
        init ();
    }

    private void init () {
        aMap = 0;
        objectMap = new ArrayList<Map> ();

        objectMap.add (new Map("shop_place"));
        objectMap.add (new Map("sword_shop"));
        objectMap.add (new Map("cave_sword_shop"));

        Gdx.input.setInputProcessor(objectMap.get(0));

    }
    public void update (float deltaTime, OrthographicCamera camera, Player player) {
        objectMap.get (aMap).render (camera, player);
    }

    public void changeMap(String index, String name, Player player){
        if(name.equals("shop_place")){
            aMap = 0;
        } else if(name.equals("sword_shop")){
            aMap = 1;
        } else if(name.equals("cave_sword_shop")){
            aMap = 2;
        }

        Gdx.input.setInputProcessor(UI.getUI_stage());

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

