package io.github.omegabird113.llamablocks.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class YellowbrickbuttonBlock extends ButtonBlock {
	public YellowbrickbuttonBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.METAL).strength(2f, 6f), BlockSetType.STONE, 20, false);
	}
}