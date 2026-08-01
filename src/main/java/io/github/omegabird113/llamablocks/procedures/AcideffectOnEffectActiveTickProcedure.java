package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.init.LlamamodModAttributes;

public class AcideffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (_ent.level() instanceof ServerLevel _serverLevel) {
				_ent.hurtServer(_serverLevel, new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.parse("llamamod:acid_damage")))),
						(float) (Math.ceil(((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) + 1.05) * 1.118)
								* (1 - Mth.clamp(entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION)
										? _livingEntity1.getAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION).getValue()
										: 0, 0, 1))));
			}
		}
	}
}