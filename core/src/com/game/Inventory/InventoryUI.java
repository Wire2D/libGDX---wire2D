package com.game.Inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.game.GUI.GUI;

/**
 * Created by Mazek27 on 26.05.16.
 */
public class InventoryUI extends Window implements Layout {

    public static Window mInventoryWindow;

    public InventoryUI() {
        super("Inventory", createWindowStyle());
        //this.setBounds(100,100,400,400);
        setVisible(false);
        setLayoutEnabled(true);

        //padTop(60);
        setPosition(140,70);
        setSize(1000,580);
        setResizable(true);
        GUI.getGUI_stage().addActor(this);
        mInventoryWindow = this;
    }

    private static WindowStyle createWindowStyle(){
        WindowStyle ws = new WindowStyle();
        ws.titleFont = new BitmapFont();
        ws.titleFontColor = Color.BLACK;
        ws.background = createDrawable(Color.RED);
        ws.stageBackground = createDrawable(new Color(0,0,0, 0.5f));

        return ws;
    }

    private static Drawable createDrawable (Color c) {
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(c);
        p.drawPixel(0, 0);

        return new SpriteDrawable(new Sprite(new Texture(p)));
    }
}
