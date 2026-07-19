package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CrackedLightGrayBricksBlock extends Block {
	public CrackedLightGrayBricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}
}