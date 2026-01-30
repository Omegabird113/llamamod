package mc.omegabird.llamablocks.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import mc.omegabird.llamablocks.procedures.VariablelightNeighbourBlockChangesProcedure;

public class VariablelightBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 16);
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	private static final VoxelShape SHAPE_NORTH = box(0, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_SOUTH = box(0, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_EAST = box(0, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_WEST = box(0, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_UP = box(0, 0, 0, 16, 16, 16);
	private static final VoxelShape SHAPE_DOWN = box(0, 0, 0, 16, 16, 16);

	public VariablelightBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.METAL).strength(13.5f, 20f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 1;
				if (s.getValue(BLOCKSTATE) == 3)
					return 2;
				if (s.getValue(BLOCKSTATE) == 4)
					return 3;
				if (s.getValue(BLOCKSTATE) == 5)
					return 4;
				if (s.getValue(BLOCKSTATE) == 6)
					return 5;
				if (s.getValue(BLOCKSTATE) == 7)
					return 6;
				if (s.getValue(BLOCKSTATE) == 8)
					return 7;
				if (s.getValue(BLOCKSTATE) == 9)
					return 8;
				if (s.getValue(BLOCKSTATE) == 10)
					return 9;
				if (s.getValue(BLOCKSTATE) == 11)
					return 10;
				if (s.getValue(BLOCKSTATE) == 12)
					return 11;
				if (s.getValue(BLOCKSTATE) == 13)
					return 12;
				if (s.getValue(BLOCKSTATE) == 14)
					return 13;
				if (s.getValue(BLOCKSTATE) == 15)
					return 14;
				if (s.getValue(BLOCKSTATE) == 16)
					return 15;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return (switch (state.getValue(FACING)) {
			case NORTH -> SHAPE_NORTH;
			case SOUTH -> SHAPE_SOUTH;
			case EAST -> SHAPE_EAST;
			case WEST -> SHAPE_WEST;
			case UP -> SHAPE_UP;
			case DOWN -> SHAPE_DOWN;
			default -> SHAPE_NORTH;
		});
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		VariablelightNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}