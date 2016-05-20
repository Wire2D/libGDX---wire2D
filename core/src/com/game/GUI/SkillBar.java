package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

/**
 * Pasek Skilla, znajdują sie tutaj skille które
 * uzytkownik wybierze do uzytku podczas walki
 * prawdopodobnie znajdą sie tutaj też potki i inne pierdoly
 * do których użytkownik bedzie miał błyskawiczny dostep
 * za pomocą klawiszy od 1 do 0
 * Created by Mazek on 2016-05-16.
 */
class SkillBar {

    private ArrayList<Rectangle> skill_block;
    private ShapeRenderer shapeRenderer;
    private NinePatch noCheckTexture = new NinePatch (new Texture(Gdx.files.internal ("res/gui/SkillBar/NoCheck.png")),9,9,9,9);
    private NinePatch checkTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/SkillBar/Check.png")),9,9,9,9);

    SkillBar(){
        skill_block = new ArrayList<Rectangle>();
        for(int i=0; i < 10; i++){
            Rectangle e = new Rectangle(390 + (i*50), 0, 50, 50);
            skill_block.add(e);
        }
        shapeRenderer = new ShapeRenderer();
    }

    void render(SpriteBatch batch, int skill){
        batch.begin();
        for(int i=0; i < 10; i++) {
            if (i == skill) {
                checkTexture.draw(batch,
                        skill_block.get(i).x,
                        skill_block.get(i).y,
                        skill_block.get(i).width,
                        skill_block.get(i).height);
            } else {
                noCheckTexture.draw(batch,
                        skill_block.get(i).x,
                        skill_block.get(i).y,
                        skill_block.get(i).width,
                        skill_block.get(i).height);
            }
        }
        batch.end();
    }

}
