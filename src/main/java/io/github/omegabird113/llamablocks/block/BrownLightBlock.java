package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BrownLightBlock extends Block {
	public BrownLightBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(12f, 16f).lightLevel(blockstate -> 15).requiresCorrectToolForDrops());
	}
}