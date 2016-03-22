package com.game.object;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Base {

    public Vector2 position;
    //public Circle punkt;
    //public Statistics statistics;
    public boolean animate = false;

    //Animacje postaci
    public Animation mUpAnimation;
    public Animation mDownAnimation;
    public Animation mRightAnimation;
    public Animation mLeftAnimation;
    public Animation mAnimation;

    //obraz postaci
    public Texture mImage;
    public Texture mUpImage;
    public Texture mDownImage;
    public Texture mRightImage;
    public Texture mLeftImage;

}
