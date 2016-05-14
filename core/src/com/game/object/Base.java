package com.game.object;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.game.object.klasy.Super_Class_Klasy;

import java.util.Random;

/**
 * Created by Mazek27 on 22.03.2016.
 */
public class Base {

    public Vector2 position;
    //public Circle punkt;
    //public Statistics statistics;
    public boolean animate = false;

    //Animacje postaci
    public Animation mUpAnimation;
    public Animation mDownAnimation;
    public Animation mRightAnimation;
    public Animation mLeftAnimation;
    public Animation mAnimation;

    //obraz postaci
    public TextureRegion mImage;
    public TextureRegion mUpImage;
    public TextureRegion mDownImage;
    public TextureRegion mRightImage;
    public TextureRegion mLeftImage;

    //Podstawowe statystyki
    protected Super_Class_Klasy klasa;
    protected int LEVEL;

    //VI podstawa;
    protected int VI_HP = 0;
    protected int VI_ATT = 0;
    protected int VI_DEF = 0;
    protected int VI_SATT = 0;
    protected int VI_SDEF = 0;
    protected int VI_SPD = 0;

    //EV podstawa;
    protected int EV_HP = 0;
    protected int EV_ATT = 0;
    protected int EV_DEF = 0;
    protected int EV_SATT = 0;
    protected int EV_SDEF = 0;
    protected int EV_SPD = 0;

    //Przerobione statystyki
    protected int HP;
    protected int mHP;
    protected int ATT;
    protected int DEF;
    protected int SATT;
    protected int SDEF;
    protected int SPD;

    public Base(Super_Class_Klasy klasa) {
        this.klasa = klasa;
        this.LEVEL = 1;

        setATT();
        setDEF();
        setHP();
        setHP(true);
        setSATT();
        setSDEF();
        setSPD();
    }

    public void setATT() {
        this.ATT = (int)(((((klasa.ATT_BASE + VI_ATT) * 2) + (Math.sqrt(EV_ATT)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setDEF() {
        this.DEF = (int)(((((klasa.DEF_BASE + VI_DEF) * 2) + (Math.sqrt(EV_DEF)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setHP() {
        this.HP = (int)(((((klasa.HP_BASE + VI_HP) * 2) + (Math.sqrt(EV_HP)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1))+ LEVEL + 10;
    }

    public void setHP(boolean a) {
        this.mHP = (int)(((((klasa.HP_BASE + VI_HP) * 2) + (Math.sqrt(EV_HP)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1))+ LEVEL + 10;
    }

    public void setSATT() {
        this.SATT = (int)(((((klasa.SATT_BASE + VI_SATT) * 2) + (Math.sqrt(EV_SATT)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setSDEF() {
        this.SDEF = (int)(((((klasa.SDEF_BASE + VI_SDEF) * 2) + (Math.sqrt(EV_SDEF)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setSPD() {
        this.SPD = (int)(((((klasa.SPD_BASE + VI_SPD) * 2) + (Math.sqrt(EV_SPD)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public int getHP() {
        return HP;
    }

    public int getmHP() {
        return mHP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }


    /**
     * Obrazenia zadawane drugiej postaci
     * @param oponent
     * @return
     */
    public String damage(Base oponent, int skill){
        int base_power = klasa.getSkillList().get(skill).getPower();
        int damage = (int) (((((2*LEVEL) + 10)*Math.pow(250,-1))*(ATT*Math.pow(oponent.DEF,-1))*base_power + 2) * modifer(oponent));
        oponent.HP -= damage;
        System.out.println(damage);
        return String.valueOf(damage);
    }


    /**
     * Obliczanie liczby randomowej do ataku
     * @return
     */
    public double modifer(Base oponent){
        Random random = new Random();
        double STAB;
        double CRITICAL;
        double OTHER = 1;
        double RANDOM = ((85 + random.nextInt(15))* 0.01f);

        if(oponent.klasa != klasa){
            STAB = 1.5;
        } else {
            STAB = 1;
        }

        if(random.nextFloat() * 100 < ((SPD + 76) / 1024)){
            CRITICAL = 2.0;
        } else {
            CRITICAL = 1.0;
        }

        double ran = STAB * CRITICAL * OTHER * RANDOM;
        return ran;
    }

}
