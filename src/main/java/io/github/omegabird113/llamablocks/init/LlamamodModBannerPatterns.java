/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.omegabird113.llamablocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.LlamamodMod;

public class LlamamodModBannerPatterns {
	public static final DeferredRegister<BannerPattern> REGISTRY = DeferredRegister.create(Registries.BANNER_PATTERN, LlamamodMod.MODID);
	public static final RegistryObject<BannerPattern> LLAMABLOCKS_BANNER_PATTERN = REGISTRY.register("llamablocks_banner_pattern", () -> new BannerPattern("llamamod:llamablocks_banner_pattern"));
	public static final RegistryObject<BannerPattern> REVERSE_LLAMABLOCKS_BANNER_PATTERN = REGISTRY.register("reverse_llamablocks_banner_pattern", () -> new BannerPattern("llamamod:reverse_llamablocks_banner_pattern"));
}