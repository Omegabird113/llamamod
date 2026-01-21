package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import mc.omegabird.llamablocks.init.LlamamodModMobEffects;

public class AcideffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))), (float) 1.5);
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) >= 4) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))),
					(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05));
		}
	}
}