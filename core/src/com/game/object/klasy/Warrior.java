package com.game.object.klasy;

import com.game.object.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Warrior extends Super_Class_Klasy {

    List<Skill> skillList;

    public Warrior() {
        super(44, 48, 65, 50, 64, 43);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill("Wrap", 5, 10));
        skillList.add(new Skill("Fury Attack", 20, 15));
        skillList.add(new Skill("Coment Punch", 15, 18));
        skillList.add(new Skill("Pound", 35, 40));
        skillList.add(new Skill("Scratch", 30, 40));
        skillList.add(new Skill("Pay Day", 20, 40));
        skillList.add(new Skill("Quick Attack", 5, 20));
        skillList.add(new Skill("Rage", 20, 35));
    }
}
