/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import io.github.omegabird113.llamablocks.world.features.BananapatchFeature;
import io.github.omegabird113.llamablocks.world.features.AcidlakeFeature;
import io.github.omegabird113.llamablocks.LlamamodMod;

@Mod.EventBusSubscriber
public class LlamamodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, LlamamodMod.MODID);
	public static final RegistryObject<Feature<?>> ACID_LAKE = REGISTRY.register("acid_lake", AcidlakeFeature::new);
	public static final RegistryObject<Feature<?>> BANANA_PATCH = REGISTRY.register("banana_patch", BananapatchFeature::new);
}