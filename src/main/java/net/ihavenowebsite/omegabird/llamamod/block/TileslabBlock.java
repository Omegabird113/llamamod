package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class TileslabBlock extends SlabBlock {
	public TileslabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).strength(7f, 23.65f).requiresCorrectToolForDrops());
	}
}