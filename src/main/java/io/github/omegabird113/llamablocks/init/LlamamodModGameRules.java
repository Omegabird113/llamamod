/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.gamerules.GameRuleTypeVisitor;
import net.minecraft.world.level.gamerules.GameRuleType;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.LlamamodMod;

import com.mojang.serialization.Codec;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class LlamamodModGameRules {
	public static final DeferredRegister<GameRule<?>> REGISTRY = DeferredRegister.create(Registries.GAME_RULE, LlamamodMod.MODID);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> GIVE_ALL_RECIPES = registerBoolean("give_all_recipes", GameRuleCategory.PLAYER, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> ALLOW_ITEM_DELETION = registerBoolean("allow_item_deletion", GameRuleCategory.MISC, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> PREVENT_NESTED_STORAGE_ITEMS = registerBoolean("prevent_nested_storage_items", GameRuleCategory.MISC, true);
	public static DeferredHolder<GameRule<?>, GameRule<Boolean>> GIVE_GOLDEN_BANANA_EFFECTS = registerBoolean("give_golden_banana_effects", GameRuleCategory.MISC, true);

	private static DeferredHolder<GameRule<?>, GameRule<Boolean>> registerBoolean(String registryname, GameRuleCategory category, boolean value) {
		return REGISTRY.register(registryname, () -> new GameRule<>(category, GameRuleType.BOOL, BoolArgumentType.bool(), GameRuleTypeVisitor::visitBoolean, Codec.BOOL, b -> b ? 1 : 0, value, FeatureFlagSet.of()));
	}
}