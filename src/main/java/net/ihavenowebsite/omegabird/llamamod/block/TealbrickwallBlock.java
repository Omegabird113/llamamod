package net.ihavenowebsite.omegabird.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class TealbrickwallBlock extends WallBlock {
	public TealbrickwallBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL).strength(2f, 6f).forceSolidOn());
	}
}