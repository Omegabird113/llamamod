/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mc.omegabird.llamablocks.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import mc.omegabird.llamablocks.client.particle.AcidparticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class LlamablocksModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(LlamablocksModParticleTypes.ACIDPARTICLE.get(), AcidparticleParticle::provider);
	}
}