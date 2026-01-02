/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.ihavenowebsite.omegabird.llamamod.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class LlamamodModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_ITEM_CLEARING;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		ALLOW_ITEM_CLEARING = GameRules.register("allowItemClearing", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	}
}