package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceGateBlock;

public class GrayLargeTileFenceGateBlock extends FenceGateBlock {
	public GrayLargeTileFenceGateBlock(BlockBehaviour.Properties properties) {
		super(WoodType.OAK, properties.sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}