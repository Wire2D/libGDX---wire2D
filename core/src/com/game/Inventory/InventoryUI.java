package com.game.Inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.sun.org.apache.bcel.internal.classfile.Utility;


/**
 * Created by Mazek on 2016-05-19.
 */
public class InventoryUI extends Window {
    private int numSlots = 50;
    private int lengthSlotRow = 10;

    private Table _inventorySlotTable;
    private Table _playerSlotsTable;
    private Table _equipSlots;
    private final int _slotWidth = 52;
    private final int _slotHeight = 52;

    public InventoryUI() {
        super("Inventory", new Skin(), "solidbackground");
    }
}
