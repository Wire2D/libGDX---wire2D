package com.game.object.Skills;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.SnapshotArray;
import com.game.GUI.GUI;
import com.game.GUI.SkillBar;
import com.game.object.klasy.Super_Class_Klasy;

import java.util.ArrayList;

/**
 * Created by Mazek on 2016-05-21.
 */
public class SkillWindow {

    private static Stage skillWindow = GUI.getGUI_stage();
    private static ArrayList<Skill_Info> cell_Skill = new ArrayList<Skill_Info>();
    private static Group cellGroup = new Group();

    public SkillWindow(Super_Class_Klasy klasa) {
        int licz = 0;
        int high = 375;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 4; j++){
                Skill_Info e = new Skill_Info(klasa.getSkillList().get(licz++));
                e.setPosition(240 + (j * 200), high);
                cellGroup.addActor(e);
                cell_Skill.add(e);
            }
            high -= 300;


        }
        cellGroup.setName("SkillWindow");
        cellGroup.setVisible(false);
        addSource();
        GUI.getGUI_stage().addActor(cellGroup);
    }

    public static void addSource() {
        for(Skill_Info cell_skill : cell_Skill) {
            SkillBar.dragAndDrop.addSource(
                    createSource(
                            cell_skill
                    ));
        }

    }

    public static void setVisibleWindow(boolean warunek){
        //warunek = !warunek;
        System.out.println(warunek);
        (skillWindow.getRoot().findActor("SkillWindow")).setVisible(warunek);
    }

    public static void removeSource(){
        for(Skill_Info skillInfo : cell_Skill) {
            SkillBar.dragAndDrop.removeSource(
                    createSource(
                            skillInfo
                    ));
            for (int j = 0; j < skillWindow.getActors().size; j++) {
                if (skillWindow.getRoot().getChildren().get(j).getName().startsWith("Skill_info+")) {
                    skillWindow.getRoot().getChildren().get(j).setVisible(false);
                }
            }
        }
        System.out.println("Usunąłem source");
    }

    public static Source createSource(final Actor source){
        return new Source(source) {
            @Override
            public void dragStop(InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
                if (target == null) {

                } else {
                    ((Image)target.getActor()).setDrawable(((Skill_Info) source).getSkillImage().getDrawable());
                }
            }

            public Payload dragStart (InputEvent event, float x, float y, int pointer) {
                Payload payload = new Payload();
                payload.setObject(source);

                payload.setDragActor(new Label("Pole", new LabelStyle(new BitmapFont(), Color.WHITE)));

                Label validLabel = new Label("Upusc!", new LabelStyle(new BitmapFont(), Color.WHITE));
                validLabel.setColor(0, 1, 0, 1);
                payload.setValidDragActor(validLabel);

                Label invalidLabel = new Label("Co ty Kurwa robisz ?!", new LabelStyle(new BitmapFont(), Color.WHITE));
                invalidLabel.setColor(1, 0, 0, 1);
                payload.setInvalidDragActor(invalidLabel);

                return payload;
            }
        };
    }
}
