package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class BlackLargeTileWallBlock extends WallBlock {
	public BlackLargeTileWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(12f, 16f).requiresCorrectToolForDrops().forceSolidOn());
	}
}