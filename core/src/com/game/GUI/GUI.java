package com.game.GUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.Inventory.InventoryUI;
import com.game.object.Skills.SkillWindow;
import com.game.object.creature.Player;
import com.game.operations.WorldController;

/**
 * Główna klasa GUI, odpowiedzialna za render
 * wszystkich informacji na temat postaci
 * z którymi gracz nie ma fizycznego kontaktu
 * Created by Mazek27 on 26.03.2016.
 */
public class GUI {

    private static Stage GUI_stage;

    private static HpBar healthBar;
    private static SpBar spBar;
    private static ExpBar expBar;
    private static SkillBar skillBar;

    public GUI(Stage gui_stage, Player player){
        this.GUI_stage = gui_stage;
        healthBar = new HpBar ();
        spBar = new SpBar ();
        expBar = new ExpBar();
        skillBar = new SkillBar(player);
        new SkillWindow(player.getKlasa());
        new InventoryUI();
    }

    public static void render(SpriteBatch batch, int aHP, int mHP, int skill, Player player){
        healthBar.render(batch,mHP,aHP);
        spBar.render(batch);
        expBar.render(batch);
        skillBar.render(batch, skill);
        GUI_stage.draw();
        //skillBar.render(batch, skill);
    }

    public static Stage getGUI_stage() {
        return GUI_stage;
    }

}
