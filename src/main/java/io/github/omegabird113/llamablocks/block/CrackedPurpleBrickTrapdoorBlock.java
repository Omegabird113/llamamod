package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class CrackedPurpleBrickTrapdoorBlock extends TrapDoorBlock {
	public CrackedPurpleBrickTrapdoorBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops(), BlockSetType.STONE);
	}
}