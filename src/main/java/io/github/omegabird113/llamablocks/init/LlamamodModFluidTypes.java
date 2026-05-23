/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import io.github.omegabird113.llamablocks.fluid.types.AcidFluidType;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, LlamamodMod.MODID);
	public static final RegistryObject<FluidType> ACID_TYPE = REGISTRY.register("acid", AcidFluidType::new);
}