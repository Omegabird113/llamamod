package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class PurpleLightBlock extends Block {
	public PurpleLightBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.METAL).strength(12f, 16f).lightLevel(blockstate -> 15).requiresCorrectToolForDrops());
	}
}