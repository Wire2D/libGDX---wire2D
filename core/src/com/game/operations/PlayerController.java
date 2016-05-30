package com.game.operations;

import com.game.Inventory.InventoryActor;
import com.game.object.Skills.SkillWindow;


public class PlayerController {

    static boolean open = false;

    public static void update (){
//        if(InputController.pressESC()){
//            game.setScreen(new MainMenuScreen(game));
//        }

        if(InputController.openSkillWindow()){
            if(!open){
                SkillWindow.setVisibleWindow(true);
                open = true;
            } else {
                SkillWindow.setVisibleWindow(false);
                open = false;
            }
        }

        if(InputController.openInventoryWindow()){
            if(InventoryActor.mInventoryWindow.isVisible()){
                InventoryActor.mInventoryWindow.setVisible(false);
            } else {
                InventoryActor.mInventoryWindow.setVisible(true);
            }
        }
    }








}
