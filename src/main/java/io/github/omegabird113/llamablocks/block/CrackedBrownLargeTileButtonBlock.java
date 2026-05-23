package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CrackedBrownLargeTileButtonBlock extends ButtonBlock {
	public CrackedBrownLargeTileButtonBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops(), BlockSetType.STONE, 20, false);
	}
}