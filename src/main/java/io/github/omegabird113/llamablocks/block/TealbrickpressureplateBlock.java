package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class TealbrickpressureplateBlock extends PressurePlateBlock {
	public TealbrickpressureplateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn(), BlockSetType.STONE);
	}
}