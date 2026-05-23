package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Blocks;

public class CrackedRedBrickStairsBlock extends StairBlock {
	public CrackedRedBrickStairsBlock() {
		super(() -> Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}

	@Override
	public float getExplosionResistance() {
		return 6f;
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return false;
	}
}