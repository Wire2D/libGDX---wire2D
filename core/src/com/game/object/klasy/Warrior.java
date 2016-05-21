package com.game.object.klasy;

import com.game.object.Skills.Skill;
import java.util.ArrayList;

/**
 * Klasa Wojownika
 * Created by Mazek on 2016-05-14.
 */
public class Warrior extends Super_Class_Klasy {

    public Warrior() {
        super(300, 48, 65, 50, 64, 43);
        skillList = new ArrayList<Skill>();
        skillList.add(new Skill(1, "Wrap", 5, 10, 120));
        skillList.add(new Skill(2, "Fury Attack", 20, 15, 150));
        skillList.add(new Skill(3, "Coment Punch", 15, 18, 300));
        skillList.add(new Skill(4, "Pound", 35, 40, 250));
        skillList.add(new Skill(5, "Scratch", 30, 40, 200));
        skillList.add(new Skill(6, "Pay Day", 20, 40, 400));
        skillList.add(new Skill(7, "Quick Attack", 5, 20, 100));
        skillList.add(new Skill(8, "Rage", 20, 35, 170));
    }
}
