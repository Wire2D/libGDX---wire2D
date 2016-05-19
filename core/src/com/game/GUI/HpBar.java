package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Pasek Życia
 * Created by Mazek27 on 26.03.2016.
 */
class HpBar {

    private NinePatch fillTexture;
    private NinePatch backTexture;

    HpBar(){
        fillTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/fill/hpBar.png")),9,9,9,9);
        backTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/backgrund/hpBar.png")),9,9,9,9);
    }

    void render(SpriteBatch batch, int mHP, int aHP){
        int width =(int)( 256* ((aHP * Math.pow(mHP, -1))));

        batch.begin();
        backTexture.draw (batch, 19, 689, 258, 20);
        fillTexture.draw (batch, 20, 690, width, 18);
        batch.end();
    }
}
