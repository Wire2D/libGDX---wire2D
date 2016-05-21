package com.game.object.Skills;

/**
 * Klasa podstawowa Skilli
 * zawiera informacje danego skilla
 * Created by Mazek on 2016-05-14.
 */
public class Skill {

    private int id;
    private String name;
    private int power_point;
    private int power;
    private int duration;

    public Skill(int id, String name, int power_point, int power, int duration) {
        this.id = id;
        this.name = name;
        this.power_point = power_point;
        this.power = power;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
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
