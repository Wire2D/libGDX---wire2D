package com.game.object.klasy;

import com.game.object.Skills.Skill;

import java.util.List;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Super_Class_Klasy {

    //Podstawowe statystyki
    public final int HP_BASE;
    public final int ATT_BASE;
    public final int DEF_BASE;
    public final int SATT_BASE;
    public final int SDEF_BASE;
    public final int SPD_BASE;

    //Skille
    protected List<Skill> skillList;

    public Super_Class_Klasy(int HP_BASE, int ATT_BASE, int DEF_BASE, int SATT_BASE, int SDEF_BASE, int SPD_BASE) {
        this.HP_BASE = HP_BASE;
        this.ATT_BASE = ATT_BASE;
        this.DEF_BASE = DEF_BASE;
        this.SATT_BASE = SATT_BASE;
        this.SDEF_BASE = SDEF_BASE;
        this.SPD_BASE = SPD_BASE;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }
}
