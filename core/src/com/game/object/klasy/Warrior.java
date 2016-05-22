package com.game.object.klasy;

import com.game.object.Skills.Skill;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Wojownika
 * Created by Mazek on 2016-05-14.
 */
public class Warrior extends Super_Class_Klasy {

    //Skille
    public static List<Skill> skillList;

    public Warrior() {
        super(300, 48, 65, 50, 64, 43);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill(1, "Wrap", 5, 10, 120, "wrap", 1));
        skillList.add(new Skill(2, "Fury Attack", 20, 15, 150, "fury_attack", 1));
        skillList.add(new Skill(3, "Coment Punch", 15, 18, 300, "coment_punch", 1));
        skillList.add(new Skill(4, "Pound", 35, 40, 250, "pound", 1));
        skillList.add(new Skill(5, "Scratch", 30, 40, 200, "scratch", 1));
        skillList.add(new Skill(6, "Pay Day", 20, 40, 400, "pay_day", 1));
        skillList.add(new Skill(7, "Quick Attack", 5, 20, 100, "quick_attack", 1));
        skillList.add(new Skill(8, "Rage", 20, 35, 170, "rage", 1));
    }

    @Override
    public List<Skill> getSkillList() {
        return skillList;
    }
}
