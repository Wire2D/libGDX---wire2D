package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.*;
import com.game.object.Skills.SkillSlot;
import com.game.object.Skills.Skill_Choose;
import com.game.object.Skills.Skill_Info;
import com.game.object.creature.Player;
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
public class SkillBar {


    public static DragAndDrop dragAndDrop = new DragAndDrop();

    private ArrayList<Actor> skill_block;
    private NinePatch noCheckTexture = new NinePatch (new Texture(Gdx.files.internal ("res/gui/SkillBar/NoCheck.png")),9,9,9,9);
    private NinePatch checkTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/SkillBar/Check.png")),9,9,9,9);
    public static Player player;

    public SkillBar(Player player) {
        skill_block = new ArrayList<Actor>();
        for(int i=0; i < 10; i++){
            Actor actor = new Actor();
            actor.setBounds(390 + (i*50), 0, 50, 50);
            skill_block.add(actor);
            //GUI.getGUI_stage().addActor(actor);
        }

        this.player = player;

        final Skin skin = new Skin();
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("Slot", new Texture("res/gui/SkillBar/NoCheck.png"));


        for(int i = 0; i < 8; i++){
            final Actor slotActor = new Actor();
            slotActor.setBounds(390 + (i*50) + 2, 2, 46, 46);
            SkillSlot slot = new SkillSlot(i, slotActor, player.getKlasa().getSkillList().get(i).getPicture());
            Image image = slot.getImageSkill();
            image.setName(String.valueOf(slot.getId()));
            GUI.getGUI_stage().addActor(slot.getImageSkill());
            dragAndDrop.addTarget(createTarget(slot, true, player));
            //!!!!
        }
    }

    public void render(SpriteBatch batch, int skill){
        batch.begin();
        for(int i=0; i < 10; i++) {
            if (i == skill) {
                checkTexture.draw(batch,
                        skill_block.get(i).getX(),
                        skill_block.get(i).getY(),
                        skill_block.get(i).getWidth(),
                        skill_block.get(i).getHeight());
            } else {
                noCheckTexture.draw(batch,
                        skill_block.get(i).getX(),
                        skill_block.get(i).getY(),
                        skill_block.get(i).getWidth(),
                        skill_block.get(i).getHeight());
            }
        }
        batch.end();
    }

    public static Target createTarget(final SkillSlot skillSlot, final boolean valid, Player player){
        final Target target = new Target(skillSlot.getImageSkill()) {

            @Override
            public void reset(Source source, Payload payload) {
                getActor().setColor(Color.valueOf("ffffffff"));
            }

            @Override
            public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
                getActor().setColor(Color.GREEN);
                return valid;
            }

            @Override
            public void drop(Source source, Payload payload, float x, float y, int pointer) {
                Skill_Info skill = (Skill_Info) source.getActor();
                Skill_Choose.choose_skill[skillSlot.getId()] = skill.getSkillId();

            }
        };
        return target;
    }
}
