package com.game.object.Skills;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Mazek on 2016-05-21.
 */
public class SkillSlot{

    private int id;
    private Actor emptySlot;
    private Image imageEmptySlot;
    private int chooseSkill;
    private Actor imageSkill;

    public SkillSlot(int id, Actor emptySlot, Image imageEmptySlot) {
        this.id = id;
        this.emptySlot = emptySlot;
        this.imageEmptySlot = imageEmptySlot;

        this.imageEmptySlot.setBounds(
                emptySlot.getX(),
                emptySlot.getY(),
                emptySlot.getWidth(),
                emptySlot.getHeight()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actor getEmptySlot() {
        return emptySlot;
    }

    public void setEmptySlot(Actor emptySlot) {
        this.emptySlot = emptySlot;
    }

    public Image getImageEmptySlot() {
        return imageEmptySlot;
    }

    public void setImageEmptySlot(Image imageEmptySlot) {
        this.imageEmptySlot = imageEmptySlot;
    }

    public int getChooseSkill() {
        return chooseSkill;
    }

    public void setChooseSkill(int chooseSkill) {
        this.chooseSkill = chooseSkill;
    }

    public Actor getImageSkill() {
        return imageSkill;
    }

    public void setImageSkill(Actor imageSkill) {
        this.imageSkill = imageSkill;
    }
}
