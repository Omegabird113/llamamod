package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedIndustrialLargeTileTrapdoorBlock extends TrapDoorBlock {
	public CrackedIndustrialLargeTileTrapdoorBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops(), BlockSetType.STONE);
	}
}