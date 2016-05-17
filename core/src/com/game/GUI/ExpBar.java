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

    private NinePatch startingBackground;
    private ShapeRenderer shapeRenderer;

    ExpBar(){
        startingBackground = new NinePatch (new Texture(Gdx.files.internal ("res/gui/expBar.png")),9,9,9,9);
        shapeRenderer = new ShapeRenderer();
    }

    void drawBar(SpriteBatch batch){

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.identity();
        shapeRenderer.rect(19,654,257,11);
        shapeRenderer.end();
        batch.begin();

        startingBackground.draw (batch, 20, 655, 256, 10);
    }

}
