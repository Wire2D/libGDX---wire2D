package com.game.object;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

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
    protected int HP_BASE;
    protected int ATT_BASE;
    protected int DEF_BASE;
    protected int SATT_BASE;
    protected int SDEF_BASE;
    protected int SPD_BASE;
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

    public Base(int ATT_BASE, int DEF_BASE, int HP_BASE, int SATT_BASE, int SDEF_BASE, int SPD_BASE, int LEVEL) {
        this.ATT_BASE = ATT_BASE;
        this.DEF_BASE = DEF_BASE;
        this.HP_BASE = HP_BASE;
        this.SATT_BASE = SATT_BASE;
        this.SDEF_BASE = SDEF_BASE;
        this.SPD_BASE = SPD_BASE;
        this.LEVEL = LEVEL;

        setATT();
        setDEF();
        setHP();
        setHP(true);
        setSATT();
        setSDEF();
        setSPD();
    }

    public void setATT() {
        this.ATT = (int)(((((ATT_BASE + VI_ATT) * 2) + (Math.sqrt(EV_ATT)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setDEF() {
        this.DEF = (int)(((((DEF_BASE + VI_DEF) * 2) + (Math.sqrt(EV_ATT)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setHP() {
        this.HP = (int)(((((HP_BASE + VI_HP) * 2) + (Math.sqrt(EV_HP)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1))+ LEVEL + 10;
    }

    public void setHP(boolean a) {
        this.mHP = (int)(((((HP_BASE + VI_HP) * 2) + (Math.sqrt(EV_HP)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1))+ LEVEL + 10;
    }

    public void setSATT() {
        this.SATT = (int)(((((SATT_BASE + VI_SATT) * 2) + (Math.sqrt(EV_SATT)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setSDEF() {
        this.SDEF = (int)(((((SDEF_BASE + VI_SDEF) * 2) + (Math.sqrt(EV_SDEF)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
    }

    public void setSPD() {
        this.SPD = (int)(((((SPD_BASE + VI_SPD) * 2) + (Math.sqrt(EV_SPD)* Math.pow(4, -1)))* LEVEL)*Math.pow(100,-1)) + 5;
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

    public String damage(Base oponent){
        int damage = (int) (((((2*LEVEL) + 10)*Math.pow(250,-1))*(ATT*Math.pow(oponent.DEF,-1))*65 + 2) * modifer());
        oponent.HP -= damage;
        System.out.println(damage);
        return String.valueOf(damage);
    }

    public double modifer(){
        Random random = new Random();
        double ran = 1.5 * 1 * 2 * 1.2 * ((85 + random.nextInt(15))* 0.01f);
        //System.out.println(ran);
        return ran;
    }

}
