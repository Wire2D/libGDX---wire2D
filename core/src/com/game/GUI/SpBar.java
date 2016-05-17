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

    private NinePatch startingBackground;
    private ShapeRenderer shapeRenderer;

    SpBar(){
        startingBackground = new NinePatch (new Texture (Gdx.files.internal ("res/gui/spBar.png")),9,9,9,9);
        shapeRenderer = new ShapeRenderer();
    }

    void drawBar(SpriteBatch batch){
        batch.end();
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.identity();
            shapeRenderer.rect(19,669,257,11);
            shapeRenderer.end();
        batch.begin();
        startingBackground.draw (batch, 20, 670, 256, 10);
    }
}
