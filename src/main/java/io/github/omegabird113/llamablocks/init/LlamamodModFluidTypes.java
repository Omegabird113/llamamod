/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import io.github.omegabird113.llamablocks.fluid.types.AcidFluidType;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, LlamamodMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> ACID_TYPE = REGISTRY.register("acid", AcidFluidType::new);
}