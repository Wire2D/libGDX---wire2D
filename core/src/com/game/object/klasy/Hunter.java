package com.game.object.klasy;

import com.game.object.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Hunter extends Super_Class_Klasy {

    List<Skill> skillList;

    public Hunter() {
        super(39, 52, 43, 60, 50, 65);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill("Normal Attack", 5, 5));
        skillList.add(new Skill("Thunder Arrow", 10, 20));
        skillList.add(new Skill("Sonic Shoot", 20, 40));
        skillList.add(new Skill("Fire Arrow", 30, 40));
        skillList.add(new Skill("Acid Arrow", 20, 40));
        skillList.add(new Skill("Octazooka", 40, 60));
        skillList.add(new Skill("Mud Shot", 5, 20));
        skillList.add(new Skill("Multi", 60, 120));
    }


}
