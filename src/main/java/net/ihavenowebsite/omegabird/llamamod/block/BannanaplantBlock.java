package net.ihavenowebsite.omegabird.llamamod.block;

import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
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
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.ihavenowebsite.omegabird.llamamod.procedures.CanBoneMealBeUsedOnBananaPlantProcedure;
import net.ihavenowebsite.omegabird.llamamod.procedures.BannanaplantOnBoneMealSuccessProcedure;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModBlocks;

public class BannanaplantBlock extends SugarCaneBlock implements BonemealableBlock, SimpleWaterloggedBlock {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public BannanaplantBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_GREEN).randomTicks().sound(SoundType.GRASS).strength(0.12f, 0.55f).noOcclusion().dynamicShape().replaceable().ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ)
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
		Vec3 offset = state.getOffset(pos);
		return box(2.6, 0, 2.6, 13.4, 16, 13.4).move(offset.x, offset.y, offset.z);
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
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return CanBoneMealBeUsedOnBananaPlantProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		BannanaplantOnBoneMealSuccessProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return FoliageColor.FOLIAGE_BIRCH;
		}, LlamamodModBlocks.BANANA_PLANT.get());
	}
}