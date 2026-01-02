package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.SoundType;

public class LightgraybricktrapdoorBlock extends TrapDoorBlock {
	public LightgraybricktrapdoorBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.sound(SoundType.METAL).strength(2f, 6f).requiresCorrectToolForDrops());
	}
}