package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Mazek27 on 26.03.2016.
 */
class ManaBar {

    private NinePatch startingBackground;
    private NinePatch loadingHealthRed;

    ManaBar(){
        startingBackground = new NinePatch (new Texture (Gdx.files.internal ("res/gui/mana.png")),9,9,9,9);
    }

    void drawBar(SpriteBatch batch){
        startingBackground.draw (batch, 20, 660, 256, 20);
    }
}
