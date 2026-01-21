/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import mc.omegabird.llamablocks.LlamamodMod;

public class LlamamodModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, LlamamodMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ACIDPARTICLE = REGISTRY.register("acidparticle", () -> new SimpleParticleType(false));
}