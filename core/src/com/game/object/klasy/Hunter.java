package com.game.object.klasy;

import com.game.object.Skills.Skill;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Lowcy
 * Created by Mazek on 2016-05-14.
 */
public class Hunter extends Super_Class_Klasy {

    //Skille
    public static List<Skill> skillList;

    public Hunter() {
        super(39, 52, 43, 60, 50, 65);
        skillList = new ArrayList<Skill>();
//        skillList.add(new Skill(1, "Normal Attack", 5, 5, 120));
//        skillList.add(new Skill(2, "Thunder Arrow", 10, 20, 150));
//        skillList.add(new Skill(3, "Sonic Shoot", 20, 40, 300));
//        skillList.add(new Skill(4, "Fire Arrow", 30, 40, 250));
//        skillList.add(new Skill(5, "Acid Arrow", 20, 40, 200));
//        skillList.add(new Skill(6, "Octazooka", 40, 60, 400));
//        skillList.add(new Skill(7, "Mud Shot", 5, 20, 100));
//        skillList.add(new Skill(8, "Multi", 60, 120, 700));
    }

    @Override
    public List<Skill> getSkillList() {
        return skillList;
    }
}
