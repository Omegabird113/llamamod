/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class LlamablocksModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == LlamablocksModItems.FARM_SCRAPS.get())
			event.setBurnTime(45);
		else if (itemstack.getItem() == LlamablocksModBlocks.BANANA_PLANT.get().asItem())
			event.setBurnTime(125);
		else if (itemstack.getItem() == LlamablocksModItems.BANANA.get())
			event.setBurnTime(100);
	}
}