package com.game.object.klasy;

import com.game.object.Skills.Skill;

import java.util.ArrayList;

/**
 * Klasa Maga
 * Created by Mazek on 2016-05-14.
 */
public class Mage extends Super_Class_Klasy {

    public Mage() {
        super(45, 49, 49, 65, 65, 45);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill(1, "Flash", 5, 10, 120));
        skillList.add(new Skill(2, "Ember", 25, 40, 150));
        skillList.add(new Skill(3, "Fire Spin", 15, 35, 300));
        skillList.add(new Skill(4, "Drain", 5, 15, 250));
        skillList.add(new Skill(5, "Mega Drain", 15, 40, 200));
        skillList.add(new Skill(6, "Bubble", 30, 50, 400));
        skillList.add(new Skill(7, "Water Gun", 25, 45, 100));
        skillList.add(new Skill(8, "Booble Beam", 20, 65, 700));
    }
}
