package com.game.object.Skills;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Mazek on 2016-05-24.
 */
public class Skill_Info extends Group {

    Image skillImage;
    Image backgroundImage;
    Label skillName;
    Label pp_need;
    Label power;
    Label duration;

    Label pp_need_value;
    Label power_value;
    Label duration_value;

    Label opis;

    public Skill_Info(Skill skill) {
        skillImage = new Image(new Texture("res/player/Skill/Warrior/"+ skill.getNameskill() +".png"));
        skillImage.setName(String.valueOf(skill.getId()));
        backgroundImage = new Image(new Texture("res/gui/SkillWindow/border.jpg"));
        skillName = new Label(skill.getName(), new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        pp_need = new Label("Power Point", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        power = new Label("Power", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        duration = new Label("Duration", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        pp_need_value = new Label(String.valueOf(skill.getPower_point()), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        power_value = new Label(String.valueOf(skill.getPower()), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        duration_value = new Label(String.valueOf(skill.getDuration()), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));

        opis = new Label(
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
                "xxxxxxxxxxxxxxxxxxxxxxxxxxx\n",
                new Label.LabelStyle(new BitmapFont(), Color.WHITE)
        );

        backgroundImage.setBounds(0,0,200,300);
        skillImage.setBounds(5,245, 50, 50);
        skillName.setBounds(100, 260, 150,50);
        pp_need.setBounds(75,230,100,50);
        power.setBounds(75,215,100,50);
        duration.setBounds(75,200,100,50);

        pp_need_value.setBounds(165,230,50,50);
        power_value.setBounds(165,215,50,50);
        duration_value.setBounds(165,200,50,50);

        opis.setBounds(5,5, 195, 195);



        addActor(backgroundImage);
        addActor(skillImage);
        addActor(skillName);
        addActor(pp_need);
        addActor(power);
        addActor(duration);
        addActor(pp_need_value);
        addActor(power_value);
        addActor(duration_value);
        addActor(opis);
        setName("Skill_info+" + skill.getName());
    }

    public void setSkillImage(Image skillImage) {
        this.skillImage = skillImage;
    }

    public Image getSkillImage() {
        return skillImage;
    }
}
