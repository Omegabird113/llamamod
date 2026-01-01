package net.mcreator.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FenceBlock;

public class IndustrialLargeTileFenceBlock extends FenceBlock {
	public IndustrialLargeTileFenceBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops().forceSolidOn());
	}
}