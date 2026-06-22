package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class AcideffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (_ent.level() instanceof ServerLevel _serverLevel) {
				_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("llamamod:acid_damage")))), (float) 1.5);
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) >= 4) {
			{
				Entity _ent = entity;
				if (_ent.level() instanceof ServerLevel _serverLevel) {
					_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("llamamod:acid_damage")))),
							(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05));
				}
			}
			LlamamodMod.LOGGER.debug(("Dealt 1.5 + " + (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05)
					+ " base Affect Effect applied damage: " + entity));
		} else if (true) {
			LlamamodMod.LOGGER.debug(("Dealt 1.5 base Affect Effect applied damage: " + entity));
		}
	}
}