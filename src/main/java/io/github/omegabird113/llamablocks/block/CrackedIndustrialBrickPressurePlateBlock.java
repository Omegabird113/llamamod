package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class CrackedIndustrialBrickPressurePlateBlock extends PressurePlateBlock {
	public CrackedIndustrialBrickPressurePlateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(28f, 75f).requiresCorrectToolForDrops().forceSolidOn(), BlockSetType.STONE);
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return BlockPathTypes.DANGER_OTHER;
	}
}