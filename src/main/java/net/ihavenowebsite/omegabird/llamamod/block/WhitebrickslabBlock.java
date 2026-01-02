package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class WhitebrickslabBlock extends SlabBlock {
	public WhitebrickslabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}
}