package net.mcreator.llamamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.llamamod.init.LlamaModModMobEffects;
import net.mcreator.llamamod.init.LlamaModModBlocks;

public class AcideffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == LlamaModModBlocks.ACID.get()
				&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.8, entity.getZ()))).getBlock() == LlamaModModBlocks.ACID.get()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 2);
		}
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llama_mod:aciddamage")))),
				(float) Math.ceil(((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(LlamaModModMobEffects.ACIDEFFECT) ? _livEnt.getEffect(LlamaModModMobEffects.ACIDEFFECT).getAmplifier() : 0) + 0.87) * 1.115));
	}
}