package com.game.object.container;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.resources.Resources;

/**
 * W sumie nie wiem, Uzupełnij to Paweł
 * Created by Khaffel on 25.03.2016.
 */
public class Chest {

    private Vector2 position;
    private TextureRegion mImage;

    public Chest(String name) {

        mImage = Resources.getTextureRegion (name)[0][0];
        position = new Vector2 (100,100);
    }

    public void render(){
        update();
    }

    private void update(){

    }
}
