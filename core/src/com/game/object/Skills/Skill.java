package com.game.object.Skills;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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
    private String nameskill;
    private Image picture;


    public Skill(int id, String name, int power_point, int power, int duration, String URL, int klasa) {
        this.id = id;
        this.name = name;
        this.power_point = power_point;
        this.power = power;
        this.duration = duration;
        this.nameskill = URL;
        switch(klasa){
            case 1:{
                this.picture = new Image(new Texture(Gdx.files.internal ("res/player/Skill/Warrior/" + URL + ".png")));
                break;
            }
            case 2:{
                this.picture = new Image(new Texture(Gdx.files.internal ("res/player/Skill/Mage/" + URL + ".png")));
                break;
            }
            case 3:{
                this.picture = new Image(new Texture(Gdx.files.internal ("res/player/Skill/Hunter/" + URL + ".png")));
                break;
            }
        }
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

    public Image getPicture() {
        return picture;
    }

    public String getNameskill() {
        return nameskill;
    }
}
