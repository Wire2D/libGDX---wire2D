package com.game.GUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

/**
 * Created by Mazek on 2016-05-16.
 */
public class SkillBar {

    ArrayList<Rectangle> skill_block;
    private ShapeRenderer shapeRenderer;

    SkillBar(){
        skill_block = new ArrayList<Rectangle>();
        for(int i=0; i < 10; i++){
            Rectangle e = new Rectangle(390 + (i*50), 0, 50, 50);

            skill_block.add(e);
        }

        shapeRenderer = new ShapeRenderer();
    }

    void render(SpriteBatch batch, int skill){
        batch.end();
        for(int i=0; i < 10; i++) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            if(i == skill){
                shapeRenderer.setColor(Color.BLUE);
                shapeRenderer.rect(skill_block.get(i).x,skill_block.get(i).y,skill_block.get(i).width,skill_block.get(i).height);
            } else {
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(skill_block.get(i).x,skill_block.get(i).y,skill_block.get(i).width,skill_block.get(i).height);
            }

            shapeRenderer.setColor(Color.GREEN);

            shapeRenderer.rect(skill_block.get(i).x + 1,skill_block.get(i).y + 1,skill_block.get(i).width - 2,skill_block.get(i).height - 2);
            shapeRenderer.end();
        }
        batch.begin();
    }

}
