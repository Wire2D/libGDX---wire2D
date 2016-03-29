package com.game.GUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Mazek27 on 26.03.2016.
 */
public class GUI {

    private HealthBar healthBar;
    private ManaBar manaBar;

    public GUI(){
        healthBar = new HealthBar ();
        manaBar = new ManaBar ();
    }

    public void render(SpriteBatch batch){
        healthBar.drawBar (batch);
        manaBar.drawBar (batch);
    }

}
