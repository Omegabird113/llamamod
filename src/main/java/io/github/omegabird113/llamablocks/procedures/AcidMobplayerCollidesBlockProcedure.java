package io.github.omegabird113.llamablocks.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.init.LlamamodModMobEffects;
import io.github.omegabird113.llamablocks.init.LlamamodModBlocks;
import io.github.omegabird113.llamablocks.init.LlamamodModAttributes;

public class AcidMobplayerCollidesBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).getBlock() == LlamamodModBlocks.ACID.get()
				&& (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.9, entity.getZ()))).getBlock() == LlamamodModBlocks.ACID.get()) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("llamamod:acid_drowning")))),
					(float) (2 * (1 - Mth.clamp(entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION)
							? _livingEntity10.getAttribute(LlamamodModAttributes.ACID_DAMAGE_PROTECTION).getValue()
							: 0, 0, 1))));
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(LlamamodModMobEffects.ACID_DISSOLVING, 150, 0, true, true));
	}
}