package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.init.LlamamodModBlocks;
import io.github.omegabird113.llamablocks.LlamamodMod;

public class AcideffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == LlamamodModBlocks.ACID.get()
				&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.9, entity.getZ()))).getBlock() == LlamamodModBlocks.ACID.get()) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_drowning")))), 2);
			LlamamodMod.LOGGER.debug(("Dealt 2 acid tick drowning damage to " + entity + " at (" + entity.getX() + ", " + entity.getY() + ", " + entity.getZ() + ")"));
		}
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_damage")))),
				(float) Math.ceil(((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) + 1.05) * 1.118));
		LlamamodMod.LOGGER
				.debug(("Dealt " + Math.ceil(((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamamodModMobEffects.ACID_DISSOLVING) ? _livEnt.getEffect(LlamamodModMobEffects.ACID_DISSOLVING).getAmplifier() : 0) + 1.05) * 1.118)
						+ " acid tick damage to " + entity + " at (" + entity.getX() + ", " + entity.getY() + ", " + entity.getZ() + ")"));
	}
}