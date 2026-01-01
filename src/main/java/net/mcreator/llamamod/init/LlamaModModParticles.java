/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.llamamod.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.llamamod.client.particle.AcidparticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class LlamaModModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(LlamaModModParticleTypes.ACIDPARTICLE.get(), AcidparticleParticle::provider);
	}
}