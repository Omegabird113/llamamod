package mc.omegabird.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import mc.omegabird.llamablocks.init.LlamablocksModMobEffects;
import mc.omegabird.llamablocks.LlamablocksMod;

public class AcideffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamablocks:acid_damage")))), (float) 1.5);
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamablocksModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamablocksModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) >= 4) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamablocks:acid_damage")))),
					(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamablocksModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamablocksModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05));
			LlamablocksMod.LOGGER
					.debug(("Dealt 1.5 + " + (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamablocksModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamablocksModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) - 2) * 3.05)
							+ " base Affect Effect applied damage: " + entity));
		} else if (true) {
			LlamablocksMod.LOGGER.debug(("Dealt 1.5 base Affect Effect applied damage: " + entity));
		}
	}
}