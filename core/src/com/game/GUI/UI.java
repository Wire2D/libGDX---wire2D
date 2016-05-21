package com.game.GUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.*;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.game.object.Skills.SkillSlot;

import java.util.ArrayList;

/**
 * Created by Mazek on 2016-05-21.
 */
public class UI {

    private static Stage UI_stage;
    private static DragAndDrop dragAndDrop = new DragAndDrop();

    ArrayList<Actor> sourceActor;
    ArrayList<SkillSlot> validActor;
    ArrayList<Actor> invalidActor;

    public UI(Stage stage) {
        this.UI_stage = stage;

        final Skin skin = new Skin();
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("Slot", new Texture("res/gui/SkillBar/NoCheck.png"));
        skin.add("badlogic", new Texture("badlogic.jpg"));

        validActor = new ArrayList<SkillSlot>();
        invalidActor = new ArrayList<Actor>();
        sourceActor = new ArrayList<Actor>();

        for(int i = 0; i < 10; i++){

            final Actor emptySlot = new Actor();
            emptySlot.setBounds(390 + (i*50), 0, 50, 50);
            SkillSlot slot = new SkillSlot(i, emptySlot,new Image(skin, "Slot"));
            UI_stage.addActor(slot.getImageEmptySlot());
            dragAndDrop.addTarget(createTarget(slot, true));
            validActor.add(slot);
        }

        final Image sourceImage1 = new Image(skin, "badlogic");
        sourceImage1.setBounds(50, 125, 50, 50);
        UI_stage.addActor(sourceImage1);
        sourceActor.add(sourceImage1);

        dragAndDrop.addSource(createSource(sourceImage1, skin));

        Image sourceImage2 = new Image(skin, "badlogic");
        sourceImage2.setBounds(125, 125, 50, 50);
        UI_stage.addActor(sourceImage2);
        sourceActor.add(sourceImage2);

        dragAndDrop.addSource(createSource(sourceImage2, skin));
    }

    public static Stage getUI_stage() {
        return UI_stage;
    }

    public static DragAndDrop getDragAndDrop() {
        return dragAndDrop;
    }

    private Target createTarget(SkillSlot skillSlot, final boolean valid){
        final Image target = skillSlot.getImageEmptySlot();
        return new Target(target) {
            @Override
            public void reset(Source source, DragAndDrop.Payload payload) {
                super.reset(source, payload);
            }

            @Override
            public boolean drag(Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
                payload.getValidDragActor().setColor(Color.GREEN);
                return valid;
            }

            @Override
            public void drop(Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {

                source.getActor().setPosition(target.getX(),target.getY());
                target.setPosition(-50,-50);
            }
        };
    }

    private Source createSource(final Actor source, final Skin skin){
        return new Source(source) {
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, DragAndDrop.Payload payload, Target target) {
                if (target == null) {
                    Actor actor = (Actor) payload.getObject();
                    actor.setPosition(50, 125);

                    System.out.println(pointer);

                    for (int i = 0; i < validActor.size(); i++) {
                        if ((validActor.get(i).getEmptySlot().getX() != validActor.get(i).getImageEmptySlot().getX()) &&
                                (validActor.get(i).getEmptySlot().getY() != validActor.get(i).getImageEmptySlot().getY())) {
                            validActor.get(i).getImageEmptySlot().setPosition(
                                    validActor.get(i).getEmptySlot().getX(),
                                    validActor.get(i).getEmptySlot().getY()
                            );
                        }
                    }
                }
            }

            public DragAndDrop.Payload dragStart (InputEvent event, float x, float y, int pointer) {
                DragAndDrop.Payload payload = new DragAndDrop.Payload();
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
