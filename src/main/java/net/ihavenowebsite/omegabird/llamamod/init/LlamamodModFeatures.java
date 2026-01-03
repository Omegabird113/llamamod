/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ihavenowebsite.omegabird.llamamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.ihavenowebsite.omegabird.llamamod.world.features.BananapatchFeature;
import net.ihavenowebsite.omegabird.llamamod.world.features.AcidlakeFeature;
import net.ihavenowebsite.omegabird.llamamod.LlamamodMod;

public class LlamamodModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, LlamamodMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> ACID_LAKE = REGISTRY.register("acid_lake", AcidlakeFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BANANA_PATCH = REGISTRY.register("banana_patch", BananapatchFeature::new);
}