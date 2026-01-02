package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CherrybrickwallBlock extends WallBlock {
	public CherrybrickwallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops().forceSolidOn());
	}
}