package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mazek27 on 26.03.2016.
 */
class HealthBar {

    private NinePatch startingBackground;
    private NinePatch loadingHealthRed;


    HealthBar(){
        startingBackground = new NinePatch (new Texture (Gdx.files.internal ("res/gui/health.jpg")),9,9,9,9);
    }

    void drawBar(SpriteBatch batch){
        startingBackground.draw (batch, 20, 690, 256, 20);
    }
}
