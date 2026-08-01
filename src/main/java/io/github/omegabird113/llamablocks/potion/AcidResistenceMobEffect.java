package io.github.omegabird113.llamablocks.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.Identifier;

import io.github.omegabird113.llamablocks.init.LlamamodModAttributes;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class AcidResistenceMobEffect extends MobEffect {
	public AcidResistenceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3342490);
		this.addAttributeModifier(LlamamodModAttributes.ACID_DAMAGE_PROTECTION, Identifier.fromNamespaceAndPath(LlamamodMod.MODID, "effect.acid_resistence_0"), 0.45, AttributeModifier.Operation.ADD_VALUE);
	}
}