package com.game.GUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Główna klasa GUI, odpowiedzialna za render
 * wszystkich informacji na temat postaci
 * z którymi gracz nie ma fizycznego kontaktu
 * Created by Mazek27 on 26.03.2016.
 */
public class GUI {

    private static HpBar healthBar;
    private static SpBar spBar;
    private static ExpBar expBar;
    private static SkillBar skillBar;

    public GUI(){
        healthBar = new HpBar ();
        spBar = new SpBar ();
        expBar = new ExpBar();
        skillBar = new SkillBar();
    }

    public static void render(SpriteBatch batch, int aHP, int mHP, int skill){
        healthBar.render(batch,mHP,aHP);
        spBar.render(batch);
        expBar.render(batch);
        skillBar.render(skill);
    }

}
