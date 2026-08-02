package io.github.omegabird113.llamablocks.block;

import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.color.block.BlockTintSources;

import java.util.List;

import io.github.omegabird113.llamablocks.procedures.CanBoneMealBeUsedOnBananaPlantProcedure;
import io.github.omegabird113.llamablocks.procedures.BannanaplantOnBoneMealSuccessProcedure;
import io.github.omegabird113.llamablocks.init.LlamamodModBlocks;

public class BannanaplantBlock extends SugarCaneBlock implements BonemealableBlock, SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape SHAPE = box(3.46, 0, 3.46, 12.62, 12, 12.52);

	public BannanaplantBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_GREEN).randomTicks().sound(SoundType.GRASS).strength(0.07f, 0.31f).noOcclusion().dynamicShape().replaceable().ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ)
				.pushReaction(PushReaction.DESTROY));
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(WATERLOGGED, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		return state == null ? null : state.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess scheduledTickAccess, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
		if (state.getValue(WATERLOGGED)) {
			scheduledTickAccess.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, world, scheduledTickAccess, currentPos, facing, facingPos, facingState, random);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return SHAPE.move(state.getOffset(pos));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return groundState.is(this) || groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT) || groundState.is(Blocks.FARMLAND) || groundState.is(Blocks.MUD) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.COARSE_DIRT);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		boolean flag = world.getBlockState(pos.above()).is(Blocks.WATER);
		if (world.isEmptyBlock(pos.above()) || flag) {
			int i = 1;
			for (; world.getBlockState(pos.below(i)).is(this); ++i);
			if (i < 5) {
				int j = blockstate.getValue(AGE);
				if (CommonHooks.canCropGrow(world, pos, blockstate, true)) {
					if (j == 15) {
						world.setBlockAndUpdate(pos.above(), defaultBlockState().setValue(WATERLOGGED, flag));
						CommonHooks.fireCropGrowPost(world, pos.above(), defaultBlockState().setValue(WATERLOGGED, flag));
						world.setBlock(pos, blockstate.setValue(AGE, 0), 4);
					} else {
						world.setBlock(pos, blockstate.setValue(AGE, j + 1), 4);
					}
				}
			}
		}
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
		if (worldIn instanceof LevelAccessor world) {
			return CanBoneMealBeUsedOnBananaPlantProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
		return false;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return CanBoneMealBeUsedOnBananaPlantProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		BannanaplantOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void blockColorLoad(RegisterColorHandlersEvent.BlockTintSources event) {
		event.getBlockColors().register(List.of(BlockTintSources.constant(FoliageColor.FOLIAGE_BIRCH)), LlamamodModBlocks.BANANA_PLANT.get());
	}
}