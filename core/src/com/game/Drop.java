package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Scene.GameScreen;
import com.game.Scene.MainMenuScreen;

/**
 * Created by Mazek27 on 28.03.2016.
 */
public class Drop extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public String platform;

    public void create() {
        batch = new SpriteBatch ();
        font = new BitmapFont ();
        this.setScreen(new GameScreen (this));

    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
