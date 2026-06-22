/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;

import io.github.omegabird113.llamablocks.fluid.AcidFluid;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, LlamamodMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> ACID = REGISTRY.register("acid", AcidFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ACID = REGISTRY.register("flowing_acid", AcidFluid.Flowing::new);
}