package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by admin on 2016-04-01.
 */
public class PlayerController {

    public static boolean pressUp(){
        if(Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)){
            return true;
        } else
            return false;
    }


    public static boolean pressDown(){
        if(Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)){
            return true;
        } else
            return false;
    }


    public static boolean pressLeft(){
        if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)){
            return true;
        } else
            return false;
    }


    public static boolean pressRight(){
        if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
            return true;
        } else
            return false;
    }



}
