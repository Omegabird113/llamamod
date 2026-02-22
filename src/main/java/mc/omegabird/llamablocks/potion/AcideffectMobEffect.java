package mc.omegabird.llamablocks.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import mc.omegabird.llamablocks.procedures.AcideffectOnEffectActiveTickProcedure;
import mc.omegabird.llamablocks.procedures.AcideffectEffectStartedappliedProcedure;

public class AcideffectMobEffect extends MobEffect {
	public AcideffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -8932233);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		AcideffectEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		AcideffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}