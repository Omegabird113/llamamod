/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.llamamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.llamamod.potion.AcideffectMobEffect;
import net.mcreator.llamamod.LlamaModMod;

public class LlamaModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, LlamaModMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ACIDEFFECT = REGISTRY.register("acideffect", () -> new AcideffectMobEffect());
}