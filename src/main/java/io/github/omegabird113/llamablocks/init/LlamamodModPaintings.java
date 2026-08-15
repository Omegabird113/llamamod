/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, LlamamodMod.MODID);
	public static final RegistryObject<PaintingVariant> WILD_ACID_LAKE = REGISTRY.register("wild_acid_lake", () -> new PaintingVariant(80, 64));
	public static final RegistryObject<PaintingVariant> ABANDONED_EXPLORATION = REGISTRY.register("abandoned_exploration", () -> new PaintingVariant(80, 64));
	public static final RegistryObject<PaintingVariant> BANANA_MOUNTAIN = REGISTRY.register("banana_mountain", () -> new PaintingVariant(80, 64));
	public static final RegistryObject<PaintingVariant> ROWS_OF_BLOCKS = REGISTRY.register("rows_of_blocks", () -> new PaintingVariant(112, 64));
}