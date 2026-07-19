package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class TealbricksBlock extends Block {
	public TealbricksBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(2f, 6f));
	}
}