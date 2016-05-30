package com.game.Inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;

/**
 * Created by Justine on 2016-05-28.
 */
public class SlotTarget extends Target {

	private Slot targetSlot;

	public SlotTarget(SlotActor actor) {
		super(actor);
		targetSlot = actor.getSlot();
		getActor().setColor(Color.LIGHT_GRAY);
	}

	@Override
	public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
		Slot payloadSlot = (Slot) payload.getObject();
		// if (targetSlot.getItem() == payloadSlot.getItem() ||
		// targetSlot.getItem() == null) {
		getActor().setColor(Color.WHITE);
		return true;
		// } else {
		// getActor().setColor(Color.DARK_GRAY);
		// return false;
		// }
	}

	@Override
	public void drop(Source source, Payload payload, float x, float y, int pointer) {
	}

	@Override
	public void reset(Source source, Payload payload) {
		getActor().setColor(Color.LIGHT_GRAY);
	}

}
