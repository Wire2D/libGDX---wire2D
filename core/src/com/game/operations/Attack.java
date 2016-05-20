package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.game.object.Base;
import com.game.object.creature.Player;

/**
 * Kontroller użycia skilla jest do poprawy
 * Created by Mazek on 2016-05-14.
 */
public class Attack {

    private Player player;
    private int cSkill;

    public Attack(Player player) {
        this.player = player;
        this.cSkill = 0;
    }

    public int getcSkill() {
        return cSkill;
    }

    public void update (Base oponent){
        float delta = Gdx.graphics.getDeltaTime ();

        if(oponent == null) {
            if (InputController.pressAttack()) {
                player.damage(player, cSkill);
                System.out.println("Życie : " + player.getHP());
            }

            if (InputController.pressSkill_1()){
                cSkill = 0;
            }

            if (InputController.pressSkill_2()){
                cSkill = 1;
            }

            if (InputController.pressSkill_3()){
                cSkill = 2;
            }

            if (InputController.pressSkill_4()){
                cSkill = 3;
            }

            if (InputController.pressSkill_5()){
                cSkill = 4;
            }

            if (InputController.pressSkill_6()){
                cSkill = 5;
            }

            if (InputController.pressSkill_7()){
                cSkill = 6;
            }

            if (InputController.pressSkill_8()){
                cSkill = 7;
            }

            if (InputController.pressSkill_9()){
                cSkill = 8;
            }

            if (InputController.pressSkill_0()){
                cSkill = 9;
            }


        } else {

            if (InputController.pressAttack()) {
                player.damage(player, cSkill);
                System.out.println("Życie : " + player.getHP());
            }

        }


    }


}
