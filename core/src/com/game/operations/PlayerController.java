package com.game.operations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.game.Inventory.InventoryUI;
import com.game.Scene.MainMenuScreen;
import com.game.androidNavigation.Nav;
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
            if(InventoryUI.mInventoryWindow.isVisible()){
                InventoryUI.mInventoryWindow.setVisible(false);
            } else {
                InventoryUI.mInventoryWindow.setVisible(true);
            }
        }
    }








}
