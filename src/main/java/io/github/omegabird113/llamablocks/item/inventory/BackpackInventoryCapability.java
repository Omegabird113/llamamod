package io.github.omegabird113.llamablocks.item.inventory;

import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemAccessItemHandler;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import io.github.omegabird113.llamablocks.world.inventory.BackpackguiMenu;
import io.github.omegabird113.llamablocks.init.LlamamodModItems;

@EventBusSubscriber
public class BackpackInventoryCapability extends ItemAccessItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == LlamamodModItems.BACKPACK.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof BackpackguiMenu)
				player.closeContainer();
		}
	}

	public BackpackInventoryCapability(ItemAccess access) {
		super(access, DataComponents.CONTAINER, 27);
	}

	@Override
	protected int getCapacity(int index, ItemResource resource) {
		return Math.min(64, super.getCapacity(index, resource));
	}

	@Override
	public boolean isValid(int index, ItemResource resource) {
		return super.isValid(index, resource) && resource.getItem() != LlamamodModItems.BACKPACK.get();
	}
}