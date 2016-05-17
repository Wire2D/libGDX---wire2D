package com.game.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa przechowuje twszystkie textury
 * Created by Mazek27 on 21.03.2016.
 */
public class Resources {

    private static Map<String, Image> images;
    private static Map<String, Texture> textureMap;
    public static Map<String, Sprite> sprites;
    private static Map<String, Sound> sounds;

    public Resources() {

        //images = new HashMap<String, Image> ();
        //sprites = new HashMap<String, Sprite> ();
        textureMap = new HashMap<String, Texture> ();
        //sounds = new HashMap<String, Sound> ();

        textureMap.put ("adas",new Texture("res/player/adas.png"));
        textureMap.put ("alwin",new Texture("res/player/alwin.png"));
        textureMap.put ("irmina",new Texture("res/player/irmina.png"));
        textureMap.put ("lili",new Texture("res/player/lili.png"));
        textureMap.put ("player",new Texture("res/player/player.png"));

        //Mob
        textureMap.put ("frog",new Texture("res/mob/mob/frog.png"));
        textureMap.put ("meduza",new Texture("res/mob/mob/meduza.png"));
        textureMap.put ("gargulec",new Texture("res/mob/mob/gargulec.png"));
        textureMap.put ("troll",new Texture("res/mob/mob/troll.png"));
    }

    public static TextureRegion[][] getTextureRegion(String path){
        return TextureRegion.split (textureMap.get (path), 32, 48);
    }

    public static TextureRegion[][] getTextureRegion(String path, boolean mob){
        return TextureRegion.split (textureMap.get (path), 32, 32);
    }

    public static Texture getTexture(String path, int x, int y){
        return getTextureRegion (path)[x][y].getTexture ();
    }
}
