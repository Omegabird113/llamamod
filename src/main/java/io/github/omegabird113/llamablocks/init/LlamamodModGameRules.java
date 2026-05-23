/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LlamamodModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> GIVE_ALL_RECIPES = GameRules.register("giveAllRecipes", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> ALLOW_ITEM_DELETION = GameRules.register("allowItemDeletion", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> PREVENT_NESTED_STORAGE_ITEMS = GameRules.register("preventNestedStorageItems", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> GIVE_GOLDEN_BANANA_EFFECTS = GameRules.register("giveGoldenBananaEffects", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}