/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.ComposterBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LlamamodModCompostableItems {
	@SubscribeEvent
	public static void addComposterItems(FMLCommonSetupEvent event) {
		ComposterBlock.COMPOSTABLES.put(LlamamodModItems.FARM_SCRAPS.get(), 0.15f);
		ComposterBlock.COMPOSTABLES.put(LlamamodModBlocks.BANANA_PLANT.get().asItem(), 0.5f);
		ComposterBlock.COMPOSTABLES.put(LlamamodModItems.BANANA.get(), 0.325f);
	}
}