package com.game.GUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Mazek27 on 26.03.2016.
 */
public class GUI {

    private static HpBar healthBar;
    private static SpBar spBar;
    private static ExpBar expBar;

    public GUI(){
        healthBar = new HpBar ();
        spBar = new SpBar ();
        expBar = new ExpBar();
    }

    public static void render(SpriteBatch batch, int aHP, int mHP){
        batch.begin();
        healthBar.drawBar (batch,mHP,aHP);
        spBar.drawBar (batch);
        expBar.drawBar(batch);
        batch.end();
    }

}
