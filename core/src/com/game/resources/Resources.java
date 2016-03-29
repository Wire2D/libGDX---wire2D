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

            /*//player
            sprites.put("player", loadSprite("res/object/creatures/player/player.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));
            sprites.put("adas", loadSprite("res/object/creatures/player/adas.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));
            sprites.put("irmina", loadSprite("res/object/creatures/player/irmina.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));
            sprites.put("lili", loadSprite("res/object/creatures/player/lili.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));
            sprites.put("alwin", loadSprite("res/object/creatures/player/alwin.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));

            //Mobs
            sprites.put("fairy", loadSprite("res/object/creatures/mob/mob/fairy.png", 32, 32));
            sprites.put("frog", loadSprite("res/object/creatures/mob/mob/frog.png", 32, 32));
            sprites.put("galkowiec", loadSprite("res/object/creatures/mob/mob/galkowiec.png", 32, 32));
            sprites.put("gargulec", loadSprite("res/object/creatures/mob/mob/gargulec.png", 32, 32));
            sprites.put("meduza", loadSprite("res/object/creatures/mob/mob/meduza.png", 32, 32));
            sprites.put("morski_gnom", loadSprite("res/object/creatures/mob/mob/morski_gnom.png", 32, 32));
            sprites.put("orangutan", loadSprite("res/object/creatures/mob/mob/orangutan.png", 32, 32));
            sprites.put("szkielet", loadSprite("res/object/creatures/mob/mob/szkielet.png", 32, 32));
            sprites.put("troll", loadSprite("res/object/creatures/mob/mob/troll.png", 32, 32));
            sprites.put("zjawa", loadSprite("res/object/creatures/mob/mob/zjawa.png", 32, 32));


            //NPC
            sprites.put("kajetan", loadSprite("res/object/creatures/npc/kajetan.png", 32, 48));
            sprites.put("burmistrz", loadSprite("res/object/creatures/npc/burmistrz.png", 32, 48));
            sprites.put("commander", loadSprite("res/object/creatures/npc/commander.png", 32, 48));
            sprites.put("lucjusz", loadSprite("res/object/creatures/npc/lucjusz.png", 32, 48));
            sprites.put("marduf", loadSprite("res/object/creatures/npc/marduf.png", 32, 48));
            sprites.put("arena_master", loadSprite("res/object/creatures/npc/arena_master.png", 32, 48));

            //boss
            sprites.put("reno", loadSprite("res/object/creatures/mob/boss/reno.png", 32, 48));
            sprites.put("rufus", loadSprite("res/object/creatures/mob/boss/rufus.png", 32, 48));
            sprites.put("bandyta", loadSprite("res/object/creatures/mob/boss/bandyta.png", 32, 48));
            sprites.put("darknymph", loadSprite("res/object/creatures/mob/boss/DarkNymph.png", 32, 48));
            sprites.put("diablik", loadSprite("res/object/creatures/mob/boss/diablik.png", 32, 48));
            sprites.put("dark_elf", loadSprite("res/object/creatures/mob/boss/dark_elf.png", 32, 48));

            //EQ
            sprites.put("bulawy", loadSprite("res/object/items/bulawy.png", 24, 24));
            sprites.put("cialo", loadSprite("res/object/items/cialo.png", 24, 24));
            sprites.put("dodatki", loadSprite("res/object/items/dodatki.png", 24, 24));
            sprites.put("glowa", loadSprite("res/object/items/glowa.png", 24, 24));
            sprites.put("miecze", loadSprite("res/object/items/miecze.png", 24, 24));
            sprites.put("mikstury", loadSprite("res/object/items/mikstury.png", 24, 24));
            sprites.put("nogi", loadSprite("res/object/items/nogi.png", 24, 24));
            sprites.put("rekawice", loadSprite("res/object/items/rekawice.png", 24, 24));
            sprites.put("rozdzki", loadSprite("res/object/items/rozdzki.png", 24, 24));
            sprites.put("staff", loadSprite("res/object/items/staff.png", 24, 24));
            sprites.put("topory", loadSprite("res/object/items/topory.png", 24, 24));
            sprites.put("wlocznie", loadSprite("res/object/items/wlocznie.png", 24, 24));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Image

    public static Texture loadImage(String path) throws Exception {
        return new Texture (path);
    }

    public static Image getImage(String getter) {
        return images.get(getter);
    }

    // SpriteSheet

    public static Sprite loadSprite(String path, int tw, int th){
        return new Sprite()
    }

    public static Sprite getSprite(String getter) {
        return sprites.get(getter);
    }

    public static Image getSpriteImage(String getter, int x, int y) {
        return sprites.get(getter).getSubImage(x, y);
    }

    // Sound

    public static Sound getSound(String getter) {
        return sounds.get(getter);
    }*/
}
