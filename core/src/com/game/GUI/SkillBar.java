package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.game.operations.WorldController;

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

    class Cell{
        Rectangle rectangle;
        Actor actor;

        public Cell(Rectangle rectangle, Actor actor) {
            this.rectangle = rectangle;
            this.actor = actor;
        }
    }

    private ArrayList<Cell> skill_block;
    private NinePatch noCheckTexture = new NinePatch (new Texture(Gdx.files.internal ("res/gui/SkillBar/NoCheck.png")),9,9,9,9);
    private NinePatch checkTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/SkillBar/Check.png")),9,9,9,9);

    SkillBar(WorldController wC){
        skill_block = new ArrayList<Cell>();
        for(int i=0; i < 10; i++){
            Rectangle e = new Rectangle(390 + (i*50), 0, 50, 50);
            Actor actor = new Actor();
            skill_block.add(new Cell(e, actor));
            wC.objectMap.get(wC.aMap).getStage().addActor(actor);
        }
    }

    void render(SpriteBatch batch, int skill){
        batch.begin();
        for(int i=0; i < 10; i++) {
            if (i == skill) {
                checkTexture.draw(batch,
                        skill_block.get(i).rectangle.x,
                        skill_block.get(i).rectangle.y,
                        skill_block.get(i).rectangle.width,
                        skill_block.get(i).rectangle.height);
            } else {
                noCheckTexture.draw(batch,
                        skill_block.get(i).rectangle.x,
                        skill_block.get(i).rectangle.y,
                        skill_block.get(i).rectangle.width,
                        skill_block.get(i).rectangle.height);
            }
        }
        batch.end();
    }

//    private DragAndDrop dragAndDrop(){
//        DragAndDrop dnd = new DragAndDrop();
//        final Skin skin = new Skin();
//
//        dnd.addSource(new DragAndDrop.Source(skill_block.get(0).actor) {
//            @Override
//            public Payload dragStart(InputEvent event, float x, float y, int pointer) {
//                Payload payload = new Payload();
//                payload.setObject("Some payload");
//
//                payload.setDragActor(new Label("Some payload", skin));
//
//            }
//        });
//    }
}
