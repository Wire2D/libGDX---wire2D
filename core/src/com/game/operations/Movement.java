package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.game.ObjectAll;
import com.game.object.creature.Player;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Movement {

    private Player player;
    private Vector2 pos;
    private float speed = 250f;

    public Movement (Player player) {
        this.player = player;
        this.pos = player.position;
    }

    public void update (ObjectAll objectAll, TiledMapTileLayer collisionLayer) {
        float delta = Gdx.graphics.getDeltaTime ();

        if(!Gdx.input.isKeyPressed(Keys.W) ||
                !Gdx.input.isKeyPressed(Keys.A) ||
                !Gdx.input.isKeyPressed(Keys.D) ||
                !Gdx.input.isKeyPressed(Keys.S)){
            player.animate = false;
        }

        /**
         * Ruch w góre
         */
        if (Gdx.input.isKeyPressed (Keys.W)) {
            player.position.y += Math.round (speed * delta);
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.position.y -= Math.round (speed * delta);
            }
            //**********************************************
            //Enter
            //**********************************************
            if (Testy.isEnter (player,collisionLayer)){
                objectAll.changeMap(objectAll.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer));
            }
            player.mImage = player.mUpImage;
            player.mAnimation = player.mUpAnimation;
        }

        /**
         * Róch w lewo
         */
        if (Gdx.input.isKeyPressed (Keys.A)) {
            player.position.x -= Math.round (speed * delta);
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.position.x += Math.round (speed * delta);
            }
            //**********************************************
            //Enter
            //**********************************************
            if (Testy.isEnter (player,collisionLayer)){
                objectAll.changeMap(objectAll.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer));
            }
            player.mImage = player.mLeftImage;
            player.mAnimation = player.mLeftAnimation;
        }

        /**
         * Ruch w prawo
         */
        if (Gdx.input.isKeyPressed (Keys.D)) {

            player.position.x += Math.round (speed * delta);
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)){
                player.position.x -= Math.round (speed * delta);
            }
            //**********************************************
            //Enter
            //**********************************************
            if (Testy.isEnter (player,collisionLayer)){
                objectAll.changeMap(objectAll.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer));
            }
            player.mImage = player.mRightImage;
            player.mAnimation = player.mRightAnimation;
        }

        /**
         * Ruch w dół
         */
        if (Gdx.input.isKeyPressed (Keys.S)) {
            player.position.y -= Math.round (speed * delta);
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.position.y += Math.round (speed * delta);
            }
            //**********************************************
            //Enter
            //**********************************************
            if (Testy.isEnter (player,collisionLayer)){
                objectAll.changeMap(objectAll.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer));
            }
            player.mImage = player.mDownImage;
            player.mAnimation = player.mDownAnimation;
        }
    }
}
