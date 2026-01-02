package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class IndustrialbrickslabBlock extends SlabBlock {
	public IndustrialbrickslabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).strength(28f, 75f).requiresCorrectToolForDrops().speedFactor(0.95f).jumpFactor(0.95f));
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.DANGER_OTHER;
	}
}