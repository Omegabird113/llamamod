package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class IndustrialLargeTilePressurePlateBlock extends PressurePlateBlock {
	public IndustrialLargeTilePressurePlateBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, properties.sound(SoundType.METAL).strength(37.75f, 86.5f).requiresCorrectToolForDrops().forceSolidOn());
	}
}