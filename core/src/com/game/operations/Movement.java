package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
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

    public void update (WorldController worldController, TiledMapTileLayer collisionLayer) {
        float delta = Gdx.graphics.getDeltaTime ();

        if(!PlayerController.pressUp() ||
                !PlayerController.pressDown() ||
                !PlayerController.pressLeft() ||
                !PlayerController.pressRight()){
            player.animate = false;
        }

        if(!Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
            speed = 250f;
            player.SpeedAnimation = 0.2f;
        }

        /**
         * Ruch w góre
         */
        if (PlayerController.pressUp()) {
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
                worldController.changeMap(worldController.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer), player);
            }
            player.mImage = player.mUpImage;
            player.mAnimation = player.mUpAnimation;
        }

        /**
         * Róch w lewo
         */
        if (PlayerController.pressLeft()) {
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
                worldController.changeMap(worldController.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mLeftImage;
            player.mAnimation = player.mLeftAnimation;
        }

        /**
         * Ruch w prawo
         */
        if (PlayerController.pressRight()) {

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
                worldController.changeMap(worldController.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mRightImage;
            player.mAnimation = player.mRightAnimation;
        }

        /**
         * Ruch w dół
         */
        if (PlayerController.pressDown()) {
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
                worldController.changeMap(worldController.ObjectMap,Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mDownImage;
            player.mAnimation = player.mDownAnimation;
        }

        if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
            speed = 350f;
            player.SpeedAnimation = 0.5f;
        }


    }
}
