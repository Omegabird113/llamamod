package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedCyanLargeTileWallBlock extends WallBlock {
	public CrackedCyanLargeTileWallBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}