package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class CrackedMagentaBrickPressurePlateBlock extends PressurePlateBlock {
	public CrackedMagentaBrickPressurePlateBlock() {
		super(Sensitivity.MOBS, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn(), BlockSetType.STONE);
	}
}