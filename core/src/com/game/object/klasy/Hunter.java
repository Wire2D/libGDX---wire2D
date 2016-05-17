package com.game.object.klasy;

import com.game.object.Skills.Skill;
import java.util.ArrayList;

/**
 * Klasa Lowcy
 * Created by Mazek on 2016-05-14.
 */
public class Hunter extends Super_Class_Klasy {

    public Hunter() {
        super(39, 52, 43, 60, 50, 65);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill("Normal Attack", 5, 5, 120));
        skillList.add(new Skill("Thunder Arrow", 10, 20, 150));
        skillList.add(new Skill("Sonic Shoot", 20, 40, 300));
        skillList.add(new Skill("Fire Arrow", 30, 40, 250));
        skillList.add(new Skill("Acid Arrow", 20, 40, 200));
        skillList.add(new Skill("Octazooka", 40, 60, 400));
        skillList.add(new Skill("Mud Shot", 5, 20, 100));
        skillList.add(new Skill("Multi", 60, 120, 700));
    }


}
