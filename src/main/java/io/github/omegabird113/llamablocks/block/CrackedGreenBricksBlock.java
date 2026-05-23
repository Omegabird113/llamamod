package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CrackedGreenBricksBlock extends Block {
	public CrackedGreenBricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(2f, 6f));
	}
}