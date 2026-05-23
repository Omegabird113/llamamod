package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class CrackedLightBlueBrickButtonBlock extends ButtonBlock {
	public CrackedLightBlueBrickButtonBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL).strength(2f, 6f), BlockSetType.STONE, 20, false);
	}
}