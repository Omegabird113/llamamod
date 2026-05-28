package io.github.omegabird113.llamablocks.client.fluid;

import org.joml.Vector4f;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

import io.github.omegabird113.llamablocks.init.LlamamodModFluids;
import io.github.omegabird113.llamablocks.init.LlamamodModFluidTypes;

@EventBusSubscriber(Dist.CLIENT)
public class AcidFluidExtension {
	@SubscribeEvent
	public static void registerRegisterFluidModels(RegisterFluidModelsEvent event) {
		event.register(new FluidModel.Unbaked(new Material(Identifier.parse("llamamod:block/acid")), new Material(Identifier.parse("llamamod:block/acid_flowing")), null, null), LlamamodModFluids.ACID, LlamamodModFluids.FLOWING_ACID);
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final Identifier RENDER_OVERLAY_TEXTURE = Identifier.parse("llamamod:textures/acid_fog.png");

			@Override
			public Identifier getRenderOverlayTexture(Minecraft minecraft) {
				return RENDER_OVERLAY_TEXTURE;
			}

			@Override
			public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
				fluidFogColor.set(0.3725490196f, 0.6470588235f, 0.3725490196f, fluidFogColor.w);
			}

			@Override
			public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
				float nearDistance = fogData.environmentalStart;
				float farDistance = fogData.environmentalEnd;
				Entity entity = camera.entity();
				Level world = entity.level();
				fogData.environmentalStart = 0.38f;
				fogData.environmentalEnd = Math.min(16.04f, renderDistance);
			}
		}, LlamamodModFluidTypes.ACID_TYPE);
	}
}