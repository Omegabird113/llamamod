package net.ihavenowebsite.omegabird.llamamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModMobEffects;

public class AcidMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(LlamamodModMobEffects.ACID_DISOLVING, 165, 0, true, true));
	}
}