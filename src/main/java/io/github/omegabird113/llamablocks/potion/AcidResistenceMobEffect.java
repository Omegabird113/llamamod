package io.github.omegabird113.llamablocks.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import io.github.omegabird113.llamablocks.init.LlamamodModAttributes;

public class AcidResistenceMobEffect extends MobEffect {
	public AcidResistenceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3342490);
		this.addAttributeModifier(LlamamodModAttributes.ACID_DAMAGE_PROTECTION.get(), "b58485ab-adf8-3d5b-8b88-cdef3a115ca7", 0.45, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}