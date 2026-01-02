package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class CherrybrickfenceBlock extends FenceBlock {
	public CherrybrickfenceBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops().forceSolidOn());
	}
}