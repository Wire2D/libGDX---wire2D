package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.game.androidNavigation.Nav;

/**
 * Klasa która nadzoruje który przycisk jest naciskany
 * przydatna klasa do stworzenia dla gracza mozliwoci
 * wyboru jakich klawiszy chciał by używać ale to później
 * Created by Mazek27 on 2016-04-01.
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

    public static boolean pressAttack(){
        return (Gdx.input.isKeyJustPressed(Keys.SPACE));
    }

    public static boolean pressSkill_1(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_1);
    }

    public static boolean pressSkill_2(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_2);
    }

    public static boolean pressSkill_3(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_3);
    }

    public static boolean pressSkill_4(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_4);
    }

    public static boolean pressSkill_5(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_5);
    }

    public static boolean pressSkill_6(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_6);
    }

    public static boolean pressSkill_7(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_7);
    }

    public static boolean pressSkill_8(){
        return Gdx.input.isKeyJustPressed(Keys.NUM_8);
    }



}
