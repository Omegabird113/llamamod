package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class CherrybrickfencegateBlock extends FenceGateBlock {
	public CherrybrickfencegateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops().forceSolidOn());
	}
}