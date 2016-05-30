package com.game.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.game.Inventory.Inventory;
import com.game.Inventory.InventoryActor;
import com.game.object.Skills.SkillWindow;
import com.game.object.creature.Player;

/**
 * Główna klasa GUI, odpowiedzialna za render
 * wszystkich informacji na temat postaci
 * z którymi gracz nie ma fizycznego kontaktu
 * Created by Mazek27 on 26.03.2016.
 */
public class GUI {

    private static Stage GUI_stage;
    private InventoryActor inventoryActor;

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
        //Skin uiSkin = Drop.assets.get("res/json/uiskin.json", Skin.class);
        new InventoryActor(new Inventory(), new DragAndDrop(), new Skin(Gdx.files.internal("res/json/uiskin.json")));
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
