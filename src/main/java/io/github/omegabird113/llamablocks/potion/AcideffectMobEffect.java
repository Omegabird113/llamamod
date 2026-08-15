package io.github.omegabird113.llamablocks.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import io.github.omegabird113.llamablocks.procedures.AcideffectOnEffectActiveTickProcedure;
import io.github.omegabird113.llamablocks.procedures.AcideffectEffectStartedappliedProcedure;

public class AcideffectMobEffect extends MobEffect {
	public AcideffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -8932233);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		AcideffectEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AcideffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}