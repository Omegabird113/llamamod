package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.init.LlamamodModAttributes;

public class AcideffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION)
				? _livingEntity0.getAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION).getValue()
				: 0) == 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))), (float) 1.5);
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) >= 4
				&& (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION)
						? _livingEntity4.getAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION).getValue()
						: 0) == 0) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))),
					(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05
							* (1 - Mth.clamp(entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION)
									? _livingEntity6.getAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION).getValue()
									: 0, 0, 1))));
		}
	}
}