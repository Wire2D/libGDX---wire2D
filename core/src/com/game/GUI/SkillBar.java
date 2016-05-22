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

    class Cell{
        Rectangle rectangle;
        Actor actor;

        public Cell(Rectangle rectangle, Actor actor) {
            this.rectangle = rectangle;
            this.actor = actor;
        }
    }

    public static DragAndDrop dragAndDrop = new DragAndDrop();

    private ArrayList<Cell> skill_block;
    private NinePatch noCheckTexture = new NinePatch (new Texture(Gdx.files.internal ("res/gui/SkillBar/NoCheck.png")),9,9,9,9);
    private NinePatch checkTexture = new NinePatch (new Texture (Gdx.files.internal ("res/gui/SkillBar/Check.png")),9,9,9,9);
    public static ArrayList<SkillSlot> validActor;
    public static Player player;
    ArrayList<Actor> invalidActor;

    public SkillBar(Player player) {
        skill_block = new ArrayList<Cell>();
        for(int i=0; i < 10; i++){
            Rectangle e = new Rectangle(390 + (i*50), 0, 50, 50);
            Actor actor = new Actor();
            skill_block.add(new Cell(e, actor));
            //GUI.getGUI_stage().addActor(actor);
        }

        this.player = player;

        final Skin skin = new Skin();
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("Slot", new Texture("res/gui/SkillBar/NoCheck.png"));
        skin.add("badlogic", new Texture("badlogic.jpg"));

        validActor = new ArrayList<SkillSlot>();
        invalidActor = new ArrayList<Actor>();

        for(int i = 0; i < 8; i++){
            final Actor slotActor = new Actor();
            slotActor.setBounds(390 + (i*50) + 2, 0 + 2, 46, 46);
            SkillSlot slot = new SkillSlot(i, slotActor, player.getKlasa().getSkillList().get(i).getPicture());
            Image image = slot.getImageSkill();
            image.setName(String.valueOf(slot.getId()));
            GUI.getGUI_stage().addActor(slot.getImageSkill());
            dragAndDrop.addTarget(createTarget(slot, true, player));
            validActor.add(slot);
        }
    }

    public void render(SpriteBatch batch, int skill){
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
                getActor().remove();
                source.getActor().setPosition(getActor().getX(),getActor().getY());
            }
        };
        return target;
    }

    public static Source createSource(final Actor source, final Skin skin){
        return new Source(source) {
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
                if (target == null) {
                    Image actor = (Image) payload.getObject();
                    System.out.println(actor.getName());
                    actor.setPosition(50, 125);
                } else {
                    payload.setObject(player.getKlasa().getSkillList().get(Integer.parseInt(source.getName())).getPicture());
                }
            }



            public Payload dragStart (InputEvent event, float x, float y, int pointer) {
                Payload payload = new Payload();
                payload.setObject(source);

                payload.setDragActor(new Label("Pole", skin));

                Label validLabel = new Label("Upusc!", skin);
                validLabel.setColor(0, 1, 0, 1);
                payload.setValidDragActor(validLabel);

                Label invalidLabel = new Label("Co ty Kurwa robisz ?!", skin);
                invalidLabel.setColor(1, 0, 0, 1);
                payload.setInvalidDragActor(invalidLabel);



                return payload;
            }
        };
    }
}
