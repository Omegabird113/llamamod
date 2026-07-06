package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class AcideffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))), (float) 1.5);
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) >= 4) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))),
					(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05));
			LlamamodMod.LOGGER.debug(("Dealt 1.5 + " + (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05)
					+ " base Affect Effect applied damage: " + entity));
		} else if (true) {
			LlamamodMod.LOGGER.debug(("Dealt 1.5 base Affect Effect applied damage: " + entity));
		}
	}
}