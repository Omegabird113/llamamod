package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class GreenbrickbuttonBlock extends ButtonBlock {
	public GreenbrickbuttonBlock(BlockBehaviour.Properties properties) {
		super(BlockSetType.STONE, 20, properties.mapColor(MapColor.COLOR_GREEN).sound(SoundType.METAL).strength(2f, 6f));
	}
}