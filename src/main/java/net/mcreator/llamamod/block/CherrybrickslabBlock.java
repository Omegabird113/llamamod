package net.mcreator.llamamod.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CherrybrickslabBlock extends SlabBlock {
	public CherrybrickslabBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops());
	}
}