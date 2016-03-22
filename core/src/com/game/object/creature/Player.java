package com.game.object.creature;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.game.object.Base;
import com.game.resources.Resources;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Player extends Base {

    public Player(String name) {
        mUpAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[3]);
        mDownAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[0]);
        mRightAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[2]);
        mLeftAnimation = new Animation(0.2f, Resources.getTextureRegion (name)[1]);
/*
        mUpImage = Resources.getSpriteImage(name, 0, 3);
        mDownImage = Resources.getSpriteImage(name, 0, 0);
        mRightImage = Resources.getSpriteImage(name, 0, 2);
        mLeftImage = Resources.getSpriteImage(name, 0, 1);

        mImage = mUpImage;
        mAnimation = mUpAnimation;
        position = new Vector2 ();
        //punkt = new Circle(position.getX(), position.getY(), 1);
        //statistics = new Statistics(70,100,8,10,10,10);
*/
    }

}
