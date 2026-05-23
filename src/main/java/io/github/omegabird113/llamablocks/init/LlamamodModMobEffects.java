/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import io.github.omegabird113.llamablocks.potion.AcideffectMobEffect;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LlamamodMod.MODID);
	public static final RegistryObject<MobEffect> ACID_DISSOLVING = REGISTRY.register("acid_dissolving", AcideffectMobEffect::new);
}