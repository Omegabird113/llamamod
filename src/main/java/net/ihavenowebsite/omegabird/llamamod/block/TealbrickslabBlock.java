package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class TealbrickslabBlock extends SlabBlock {
	public TealbrickslabBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(2f, 6f));
	}
}