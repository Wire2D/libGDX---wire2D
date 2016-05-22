package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.game.androidNavigation.Nav;

/**
 * Klasa która nadzoruje który przycisk jest naciskany
 * przydatna klasa do stworzenia dla gracza mozliwoci
 * wyboru jakich klawiszy chciał by używać ale to później
 * Created by Mazek27 on 2016-04-01.
 */
public class InputController {

    /**
     * Klawisze ruchu
     * @return
     */
    public static boolean pressUp(){
        return (Gdx.input.isKeyPressed(Input.Keys.W) ||
                Gdx.input.isKeyPressed(Input.Keys.UP) ||
                Nav.upNavPress);
    }


    public static boolean pressDown(){
        return (Gdx.input.isKeyPressed(Input.Keys.S) ||
                Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
                Nav.downNavPress);
    }


    public static boolean pressLeft(){
        return (Gdx.input.isKeyPressed(Input.Keys.A) ||
                Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
                Nav.leftNavPress);
    }


    public static boolean pressRight(){
        return (Gdx.input.isKeyPressed(Input.Keys.D) ||
                Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
                Nav.rightNavPress);
    }

    /**
     * Klawisze obsługi skillbaru
     * @return
     */
    public static boolean pressAttack(){
        return (Gdx.input.isKeyJustPressed(Input.Keys.SPACE));
    }

    public static boolean pressSkill_1(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_1);
    }

    public static boolean pressSkill_2(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_2);
    }

    public static boolean pressSkill_3(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_3);
    }

    public static boolean pressSkill_4(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_4);
    }

    public static boolean pressSkill_5(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_5);
    }

    public static boolean pressSkill_6(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_6);
    }

    public static boolean pressSkill_7(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_7);
    }

    public static boolean pressSkill_8(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_8);
    }

    public static boolean pressSkill_9(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_9);
    }

    public static boolean pressSkill_0(){
        return Gdx.input.isKeyJustPressed(Input.Keys.NUM_0);
    }

    /**
     * Klawisze przejscia do menu
     */
    public static boolean pressESC(){
        return Gdx.input.isKeyJustPressed((Input.Keys.ESCAPE));
    }

    public static boolean openSkillWindow(){
        return Gdx.input.isKeyJustPressed(Input.Keys.K);
    }

}
