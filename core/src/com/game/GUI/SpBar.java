package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Pasek SP
 * Created by Mazek27 on 26.03.2016.
 */
class SpBar {

    private NinePatch fillTexture;
    private NinePatch backTexture;

    SpBar(){
        fillTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/fill/spBar.png")),9,9,9,9);
        backTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/backgrund/spBar.png")),9,9,9,9);
    }

    void render(SpriteBatch batch){
        batch.begin();
        backTexture.draw (batch, 19, 669, 258, 12);
        fillTexture.draw (batch, 20, 670, 256, 10);
        batch.end();
    }
}
