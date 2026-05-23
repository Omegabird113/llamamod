package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CeilingtilebuttonBlock extends ButtonBlock {
	public CeilingtilebuttonBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(25.5f, 33f).requiresCorrectToolForDrops(), BlockSetType.STONE, 20, false);
	}
}