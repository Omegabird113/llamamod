package net.mcreator.llamamod.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CherrybrickbuttonBlock extends ButtonBlock {
	public CherrybrickbuttonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.OAK, 30, properties.sound(SoundType.METAL).strength(18f, 37f).requiresCorrectToolForDrops());
	}
}