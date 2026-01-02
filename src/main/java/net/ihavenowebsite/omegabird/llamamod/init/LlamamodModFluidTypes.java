/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.ihavenowebsite.omegabird.llamamod.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.ihavenowebsite.omegabird.llamamod.fluid.types.AcidFluidType;
import net.ihavenowebsite.omegabird.llamamod.LlamamodMod;

public class LlamamodModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, LlamamodMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> ACID_TYPE = REGISTRY.register("acid", () -> new AcidFluidType());
}