/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LlamamodMod.MODID);
	public static final RegistryObject<SimpleParticleType> ACIDPARTICLE = REGISTRY.register("acidparticle", () -> new SimpleParticleType(false));
}