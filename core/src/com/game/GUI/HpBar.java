package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mazek27 on 26.03.2016.
 */
class HpBar {

    private NinePatch startingBackground;
    private Rectangle border;
    private ShapeRenderer shapeRenderer;


    HpBar(){
        startingBackground = new NinePatch (new Texture (Gdx.files.internal ("res/gui/hpBar.png")),9,9,9,9);
        //border = new Rectangle();
        //border.set(19,689,258,22);
        shapeRenderer = new ShapeRenderer();
    }

    void drawBar(SpriteBatch batch, int mHP, int aHP){
        int width =(int)( 256* ((aHP * Math.pow(mHP, -1))));

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.identity();
        shapeRenderer.rect(19,689,257,19);
        shapeRenderer.end();
        batch.begin();

        startingBackground.draw (batch, 20, 690, width, 18);

    }
}
