package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CyanBricksBlock extends Block {
	public CyanBricksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}