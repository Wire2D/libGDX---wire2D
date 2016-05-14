package com.game.object.Skills;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Skill {

    String name;
    int power_point;
    int power;

    public Skill(String name, int power_point, int power) {
        this.name = name;
        this.power_point = power_point;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower_point() {
        return power_point;
    }

    public int getPower() {
        return power;
    }
}
