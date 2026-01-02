package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class YellowLargeTileSlabBlock extends SlabBlock {
	public YellowLargeTileSlabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops());
	}
}