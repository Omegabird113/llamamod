/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.ihavenowebsite.omegabird.llamamod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.ihavenowebsite.omegabird.llamamod.fluid.AcidFluid;
import net.ihavenowebsite.omegabird.llamamod.LlamamodMod;

public class LlamamodModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, LlamamodMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> ACID = REGISTRY.register("acid", () -> new AcidFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ACID = REGISTRY.register("flowing_acid", () -> new AcidFluid.Flowing());

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(ACID.get(), ChunkSectionLayer.TRANSLUCENT);
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ACID.get(), ChunkSectionLayer.TRANSLUCENT);
		}
	}
}