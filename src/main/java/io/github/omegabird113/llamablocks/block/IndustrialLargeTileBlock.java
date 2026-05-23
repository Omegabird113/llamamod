package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class IndustrialLargeTileBlock extends Block {
	public IndustrialLargeTileBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops());
	}
}