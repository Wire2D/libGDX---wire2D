package com.game.operations;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.game.object.Base;
import com.game.object.creature.Player;

/**
 * Created by Mazek27 on 23.03.2016.
 */
public class Testy {

    /*
    * scorpion43 dokonał zmiany parametru funkcji z Player na Baze
    * */
    public static boolean isBlock(Base player, TiledMapTileLayer collisionLayer){
        return collisionLayer.getCell (
                (int) (player.position.x / 32),
                (int) (player.position.y / 32))
                .getTile ().getProperties ().containsKey ("blocked");
    }

    public static boolean isEnter(Player player, TiledMapTileLayer collisionLayer){
        return collisionLayer.getCell (
                (int) (player.position.x / 32),
                (int) (player.position.y / 32))
                .getTile ().getProperties ().containsKey ("enter");
    }

    public static String name(Player player, TiledMapTileLayer collisionLayer){
        return collisionLayer.getCell (
                (int) (player.position.x / 32),
                (int) (player.position.y / 32))
                .getTile ().getProperties ().get ("map", "false", String.class);
    }

    public static String name(TiledMapTileLayer collisionLayer, int x, int y){
        return collisionLayer.getCell (x, y)
                .getTile ().getProperties ().get ("name", null, String.class);
    }

    public static boolean isSpawn(TiledMapTileLayer collisionLayer, int x, int y){
        return collisionLayer.getCell (x, y)
                .getTile ().getProperties ().containsKey ("spawn");
    }

    public static String index(Player player, TiledMapTileLayer collisionLayer){
        return collisionLayer.getCell (
                (int) (player.position.x / 32),
                (int) (player.position.y / 32))
                .getTile ().getProperties ().get ("index", null, String.class);
    }

    public static String index(TiledMapTileLayer collisionLayer, int x, int y){
        return collisionLayer.getCell (x, y)
                .getTile ().getProperties ().get ("index", null, String.class);
    }

    public static boolean isMob(TiledMapTileLayer collisionLayer, int x, int y){
        return collisionLayer.getCell (x, y)
                .getTile ().getProperties ().containsKey ("mob");
    }

    public static String getLevel(TiledMapTileLayer collisionLayer, int x, int y){
        return collisionLayer.getCell (x, y)
                .getTile ().getProperties ().get ("level", null, String.class);
    }


}
