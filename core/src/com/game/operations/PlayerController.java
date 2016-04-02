package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.game.androidNavigation.Nav;

/**
 * Created by admin on 2016-04-01.
 */
public class PlayerController {

    public static boolean pressUp(){
        return (Gdx.input.isKeyPressed(Keys.W) ||
                Gdx.input.isKeyPressed(Keys.UP) ||
                Nav.upNavPress);
    }


    public static boolean pressDown(){
        return (Gdx.input.isKeyPressed(Keys.S) ||
                Gdx.input.isKeyPressed(Keys.DOWN) ||
                Nav.downNavPress);
    }


    public static boolean pressLeft(){
        return (Gdx.input.isKeyPressed(Keys.A) ||
                Gdx.input.isKeyPressed(Keys.LEFT) ||
                Nav.leftNavPress);
    }


    public static boolean pressRight(){
        return (Gdx.input.isKeyPressed(Keys.D) ||
                Gdx.input.isKeyPressed(Keys.RIGHT) ||
                Nav.rightNavPress);
    }



}
