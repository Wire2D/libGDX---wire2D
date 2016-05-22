package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.game.Drop;
import com.game.Scene.MainMenuScreen;
import com.game.object.Skills.SkillWindow;
import com.game.object.creature.Player;

/**
 * Kontroller Ruchu odpowiada za to co dzieje sie w grze
 * poprzez aktywność gracza
 * Created by Mazek27 on 22.03.2016.
 */
public class Movement {

    private Player player;
    private float speed = 250f;
    private boolean open = false;

    public Movement (Player player) {
        this.player = player;
    }

    public void update (WorldController worldController, TiledMapTileLayer collisionLayer, Drop game) {
        float delta = Gdx.graphics.getDeltaTime ();

        if(!InputController.pressUp() ||
                !InputController.pressDown() ||
                !InputController.pressLeft() ||
                !InputController.pressRight()){
            player.animate = false;
        }

        if(!Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
            speed = 250f;
            player.SpeedAnimation = 0.2f;
        }

        /**
         * Ruch w góre
         */
        if (InputController.pressUp()) {
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
                worldController.changeMap(Testy.index(player,collisionLayer),Testy.name(player,collisionLayer), player);
            }
            player.mImage = player.mUpImage;
            player.mAnimation = player.mUpAnimation;
        }

        /**
         * Róch w lewo
         */
        if (InputController.pressLeft()) {
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
                worldController.changeMap(Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mLeftImage;
            player.mAnimation = player.mLeftAnimation;
        }

        /**
         * Ruch w prawo
         */
        if (InputController.pressRight()) {

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
                worldController.changeMap(Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mRightImage;
            player.mAnimation = player.mRightAnimation;
        }

        /**
         * Ruch w dół
         */
        if (InputController.pressDown()) {
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
                worldController.changeMap(Testy.index(player,collisionLayer),Testy.name(player,collisionLayer) ,player);
            }
            player.mImage = player.mDownImage;
            player.mAnimation = player.mDownAnimation;
        }

        if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
            speed = 350f;
            player.SpeedAnimation = 0.5f;
        }

        if(InputController.pressESC()){
            game.setScreen(new MainMenuScreen(game));
        }

//        if(InputController.openSkillWindow()){
//            if(!open){
//                SkillWindow.addSource();
//                open = true;
//            } else {
//                SkillWindow.removeSource();
//                open = false;
//            }
//        }


    }
}
