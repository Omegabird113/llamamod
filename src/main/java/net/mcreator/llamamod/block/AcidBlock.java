package net.mcreator.llamamod.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.llamamod.procedures.AcidMobplayerCollidesBlockProcedure;
import net.mcreator.llamamod.init.LlamaModModFluids;

public class AcidBlock extends LiquidBlock {
	public AcidBlock(BlockBehaviour.Properties properties) {
		super(LlamaModModFluids.ACID.get(), properties.mapColor(MapColor.WARPED_WART_BLOCK).strength(13f).lightLevel(s -> 5).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 400;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 2;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier) {
		super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier);
		AcidMobplayerCollidesBlockProcedure.execute(entity);
	}
}