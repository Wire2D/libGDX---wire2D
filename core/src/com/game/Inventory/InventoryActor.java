
package com.game.Inventory;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.Array;
import com.game.GUI.GUI;

/**
 * Created by Justine on 2016-05-28.
 */
public class InventoryActor extends Window {

	public static Window mInventoryWindow;
	public Array<SlotActor> slots;

	public InventoryActor(Inventory inventory, DragAndDrop dragAndDrop, Skin skin) {
		super("Inventory...", skin);

		TextButton closeButton = new TextButton("X", skin);
		closeButton.addListener(new HidingClickListener(this));
		add(closeButton).height(getPadTop());
		setName("Inventory");

		setPosition(400, 100);
		defaults().space(8);
		row().fill().expandX();

		int i = 0;
		for (Slot slot : inventory.getSlots()) {
			SlotActor slotActor = new SlotActor(skin, slot);
			dragAndDrop.addSource(new SlotSource(slotActor));
			dragAndDrop.addTarget(new SlotTarget(slotActor));
			add(slotActor);

			i++;
			if (i % 10 == 0) {
				row();
			}
		}

		pack();


		setVisible(false);
		mInventoryWindow = this;
		GUI.getGUI_stage().addActor(this);
	}

}
