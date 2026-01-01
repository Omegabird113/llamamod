package net.mcreator.llamamod.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class CeilingtilewallBlock extends WallBlock {
	public CeilingtilewallBlock(BlockBehaviour.Properties properties) {
		super(properties.mapColor(MapColor.CLAY).sound(SoundType.METAL).strength(19f, 33f).requiresCorrectToolForDrops().forceSolidOn());
	}
}