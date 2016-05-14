package com.game.object.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.object.Base;
import com.game.resources.Resources;

/**
 * Created by Khaffel on 25.03.2016.
 */
public class Npc extends Base {

    private TextureRegion currentFrame;
    float stateTime;

    public Npc(String name) {
        super(49,49,45,65,65,45,100);
        mUpAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[3]);
        mDownAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[0]);
        mRightAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[2]);
        mLeftAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[1]);


        mUpImage = Resources.getTextureRegion (name)[3][0];
        mDownImage = Resources.getTextureRegion (name)[0][0];
        mRightImage = Resources.getTextureRegion (name)[2][0];
        mLeftImage = Resources.getTextureRegion (name)[1][0];

        mImage = mUpImage;
        mAnimation = mUpAnimation;
        position = new Vector2 (200,200);
    }

    public void render(SpriteBatch batch){
        update();
        if(animate){
            stateTime += Gdx.graphics.getDeltaTime();           // #15
            currentFrame = mAnimation.getKeyFrame(stateTime, true);
            batch.draw (currentFrame,position.x - 16,position.y- 5);
        } else {
            batch.draw (mImage, position.x - 16, position.y- 5);
        }
    }

    private void update(){

    }
}
