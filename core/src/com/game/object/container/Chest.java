package com.game.object.container;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.resources.Resources;

/**
 * Created by Khaffel on 25.03.2016.
 */
public class Chest {

    public Vector2 position;
    public TextureRegion mImage;

    //public ArrayList<Item> content;

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
