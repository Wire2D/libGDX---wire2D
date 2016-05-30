package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Pasek Doświadczenia
 * Created by Mazek on 2016-05-13.
 */
class ExpBar {

    private NinePatch fillTexture;
    private NinePatch backTexture;

    ExpBar(){
        fillTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/fill/expBar.png")),9,9,9,9);
        backTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/backgrund/expBar.png")),9,9,9,9);
    }

    void render(SpriteBatch batch){
        batch.begin();
        backTexture.draw (batch, 19, 654, 258, 12);
        fillTexture.draw (batch, 20, 655, 256, 10);
        batch.end();
    }

}
