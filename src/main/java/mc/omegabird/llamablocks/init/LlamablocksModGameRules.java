/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class LlamablocksModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> GIVE_ALL_RECIPES;
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_ITEM_DELETION;
	public static GameRules.Key<GameRules.BooleanValue> PREVENT_NESTED_STORAGE_ITEMS;
	public static GameRules.Key<GameRules.BooleanValue> GIVE_GOLDEN_BANANA_EFFECTS;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		GIVE_ALL_RECIPES = GameRules.register("giveAllRecipes", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
		ALLOW_ITEM_DELETION = GameRules.register("allowItemDeletion", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		PREVENT_NESTED_STORAGE_ITEMS = GameRules.register("preventNestedStorageItems", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
		GIVE_GOLDEN_BANANA_EFFECTS = GameRules.register("giveGoldenBananaEffects", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	}
}