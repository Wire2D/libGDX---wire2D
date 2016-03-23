package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.object.Map;
import com.game.object.creature.Player;
import com.game.operations.Testy;

import java.util.ArrayList;

/**
 * Created by Mazek27 on 21.03.2016.
 */

// TEST
public class ObjectAll {
    public static ArrayList<Map> ObjectMap;
    OrthographicCamera camera;
    public int aMap;

    Viewport viewport;
    Player mPlayer;

    public ObjectAll(String platform){
        mPlayer = new Player ("player");
        aMap = 0;

        float w = Gdx.app.getGraphics().getWidth();
        float h = Gdx.app.getGraphics().getHeight();

        System.err.println("Width: " + w);
        System.err.println("Height: " + h);

        ObjectMap = new ArrayList<Map> ();
        ObjectMap.add (new Map("shop_place"));

        camera = new OrthographicCamera();
        if(platform.equals ("desktop")){
            viewport = new FillViewport (w,h,camera);
            viewport.apply();
            camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        } else {
            viewport = new FillViewport (w,h, camera);
            viewport.apply();
            camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0);
        }
        camera.update();
    }

    public void render(){
        ObjectMap.get (aMap).render (camera);
    }

    public void changeMap(ArrayList<Map> objectMap, String index, String name){
        for(int i = 0 ; i < objectMap.size (); i++){
            if(objectMap.get (i).mName == name){
                this.aMap = i;
                break;
            }

            if(i == objectMap.size () -1){
                ObjectMap.add (new Map(name));
                this.aMap = ObjectMap.size () - 1;
            }

        }

        TiledMapTileLayer TMTL = (TiledMapTileLayer) ObjectMap.get (aMap).mMap.getLayers ().get (0);

        for(int i = 0; i < 40; i++){
            for(int j = 0; j < 20; j++){
                //System.err.println(Testy.isSpawn (mPlayer,TMTL,i,j));
                if(Testy.isSpawn (TMTL,i,j)){
                    System.err.println("dziala " + index + " = " + Testy.index (TMTL,i,j));
                    if(Testy.index (TMTL,i,j).equals (index)){
                        mPlayer.position.set(i * 32, j * 32);
                        break;
                    }
                }
            }
        }
    }
}
