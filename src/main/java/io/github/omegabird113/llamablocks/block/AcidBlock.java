package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import io.github.omegabird113.llamablocks.procedures.AcidMobplayerCollidesBlockProcedure;
import io.github.omegabird113.llamablocks.init.LlamamodModFluids;

public class AcidBlock extends LiquidBlock {
	public AcidBlock() {
		super(LlamamodModFluids.ACID.get(),
				BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).strength(13f).lightLevel(state -> 5).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 400;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 2;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		AcidMobplayerCollidesBlockProcedure.execute(entity);
	}
}