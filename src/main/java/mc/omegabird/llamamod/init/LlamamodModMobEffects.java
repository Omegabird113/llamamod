/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import mc.omegabird.llamamod.potion.AcideffectMobEffect;
import mc.omegabird.llamamod.LlamamodMod;

public class LlamamodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, LlamamodMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> ACID_DISSOLVING = REGISTRY.register("acid_dissolving", () -> new AcideffectMobEffect());
}