package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class RedLightBlock extends Block {
	public RedLightBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.METAL).strength(12f, 16f).lightLevel(blockstate -> 15).requiresCorrectToolForDrops());
	}
}