package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class CyanbrickfencegateBlock extends FenceGateBlock {
	public CyanbrickfencegateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops().forceSolidOn());
	}
}