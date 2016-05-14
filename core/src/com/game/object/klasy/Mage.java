package com.game.object.klasy;

import com.game.object.Skills.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Mage extends Super_Class_Klasy {

    List<Skill> skillList;

    public Mage() {
        super(45, 49, 49, 65, 65, 45);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill("Flash", 5, 10));
        skillList.add(new Skill("Ember", 25, 40));
        skillList.add(new Skill("Fire Spin", 15, 35));
        skillList.add(new Skill("Drain", 5, 15));
        skillList.add(new Skill("Mega Drain", 15, 40));
        skillList.add(new Skill("Bubble", 30, 50));
        skillList.add(new Skill("Water Gun", 25, 45));
        skillList.add(new Skill("Booble Beam", 20, 65));
    }
}
