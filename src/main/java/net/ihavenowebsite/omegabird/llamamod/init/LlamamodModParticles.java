/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ihavenowebsite.omegabird.llamamod.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.ihavenowebsite.omegabird.llamamod.client.particle.AcidparticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class LlamamodModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(LlamamodModParticleTypes.ACIDPARTICLE.get(), AcidparticleParticle::provider);
	}
}