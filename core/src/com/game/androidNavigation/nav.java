package com.game.androidNavigation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Dariusz on 2016-04-01.
 */
public class Nav {
    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private SpriteBatch batch;

    public Nav() {
        upButton = new ImageButton((Drawable) new Texture("res/"));
        downButton = new ImageButton((Drawable) new Texture("res/"));
        leftButton = new ImageButton((Drawable) new Texture("res/"));
        rightButton = new ImageButton((Drawable) new Texture("res/"));
    }
}
