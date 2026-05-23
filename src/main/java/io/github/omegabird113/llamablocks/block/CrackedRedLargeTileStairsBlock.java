package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CrackedRedLargeTileStairsBlock extends StairBlock {
	public CrackedRedLargeTileStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 16f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}