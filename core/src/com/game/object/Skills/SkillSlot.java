package com.game.object.Skills;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Mazek on 2016-05-21.
 */
public class SkillSlot{

    private int id;
    private Image imageSkill;

    public SkillSlot(int id, Actor slot, Image image) {
        this.id = id;
        this.imageSkill = image;
        this.imageSkill.setBounds(
                slot.getX(),
                slot.getY(),
                slot.getWidth(),
                slot.getHeight()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImageSkill() {
        return imageSkill;
    }

    public void setImageSkill(Image imageSkill) {
        this.imageSkill = imageSkill;
    }
}
