package com.game.object.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.game.object.Base;
import com.game.object.klasy.Warrior;
import com.game.resources.Resources;

/**
 * Klasa Playera przydała by sie lekka rozbudowa
 * o podstawowe funkcje dostepne tylko dla playera
 * Created by Mazek27 on 22.03.2016.
 */
public class Player extends Base {

    private TextureRegion currentFrame;
    float stateTime;
    public float SpeedAnimation = 0.2f;

    public Player(String name) {
        super(new Warrior());
        mUpAnimation = new Animation(SpeedAnimation, Resources.getTextureRegion (name)[3]);
        mDownAnimation = new Animation(SpeedAnimation, Resources.getTextureRegion (name)[0]);
        mRightAnimation = new Animation(SpeedAnimation, Resources.getTextureRegion (name)[2]);
        mLeftAnimation = new Animation(SpeedAnimation, Resources.getTextureRegion (name)[1]);


        mUpImage = Resources.getTextureRegion (name)[3][0];
        mDownImage = Resources.getTextureRegion (name)[0][0];
        mRightImage = Resources.getTextureRegion (name)[2][0];
        mLeftImage = Resources.getTextureRegion (name)[1][0];

        mImage = mUpImage;
        mAnimation = mUpAnimation;
        position = new Vector2 (100,100);
    }

    public void render(SpriteBatch batch){
        update();
        batch.begin();
        if(animate){
            stateTime += Gdx.graphics.getDeltaTime();           // #15
            currentFrame = mAnimation.getKeyFrame(stateTime, true);
            batch.draw (currentFrame,position.x - 16,position.y- 5);
        } else {
            batch.draw (mImage, position.x - 16, position.y- 5);
        }
        batch.end();
    }

    private void update(){

    }
}
