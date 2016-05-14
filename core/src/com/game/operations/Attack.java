package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.game.object.Base;
import com.game.object.creature.Player;

/**
 * Created by Mazek on 2016-05-14.
 */
public class Attack {

    private Player player;
    private int cSkill;

    public Attack(Player player) {
        this.player = player;
        this.cSkill = 0;
    }

    public void update (Base oponent){
        float delta = Gdx.graphics.getDeltaTime ();

        if(oponent == null) {
            if (PlayerController.pressAttack()) {
                //player.setHP(player.getHP() - 1);
                player.damage(player, cSkill);
                System.out.println("Życie : " + player.getHP());
            }

            if (PlayerController.pressSkill_1()){
                cSkill = 0;
            }

            if (PlayerController.pressSkill_2()){
                cSkill = 1;
            }

            if (PlayerController.pressSkill_3()){
                cSkill = 2;
            }

            if (PlayerController.pressSkill_4()){
                cSkill = 3;
            }

            if (PlayerController.pressSkill_5()){
                cSkill = 4;
            }

            if (PlayerController.pressSkill_6()){
                cSkill = 5;
            }

            if (PlayerController.pressSkill_7()){
                cSkill = 6;
            }

            if (PlayerController.pressSkill_8()){
                cSkill = 7;
            }


        } else {

            if (PlayerController.pressAttack()) {
                player.damage(player, cSkill);
                System.out.println("Życie : " + player.getHP());
            }

        }


    }


}
