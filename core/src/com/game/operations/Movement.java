package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.game.Drop;
import com.game.Scene.MainMenuScreen;
import com.game.object.creature.Player;

/**
 * Kontroller Ruchu odpowiada za to co dzieje sie w grze
 * poprzez aktywność gracza
 * Created by Mazek27 on 22.03.2016.
 */
public class Movement {

    private Player player;
    private float speed = 250f;

    public Movement (Player player) {
        this.player = player;
    }

    public void update (WorldController worldController, TiledMapTileLayer collisionLayer, Drop game) {
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
            player.setY(player.getY() + Math.round (speed * delta));
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.setY(player.getY() - Math.round (speed * delta));
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
            player.setX(player.getX() - Math.round (speed * delta));
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.setX(player.getX() + Math.round (speed * delta));
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

            player.setX(player.getX() + Math.round (speed * delta));
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)){
                player.setX(player.getX() - Math.round (speed * delta));
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
            player.setY(player.getY() - Math.round (speed * delta));
            player.animate = true;
            //**********************************************
            //Block
            //**********************************************
            if (Testy.isBlock (player,collisionLayer)) {
                player.setY(player.getY() + Math.round (speed * delta));
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

        if(PlayerController.pressESC()){
            game.setScreen(new MainMenuScreen(game));
        }


    }
}
